package ru.otus.spring.prokopov.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import ru.otus.spring.prokopov.configuration.MessageSource;
import ru.otus.spring.prokopov.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Component
@EnableConfigurationProperties(MessageSource.class)
public class QuestionDAOImpl implements QuestionDAO {

    private final MessageSource messageSource;
    private final LocaleDAO localeDAO;


    @Override
    public List<Question> getAllQuestion() throws IOException {
        List<Question> result = Collections.emptyList();
        Map<String, String> localesMessage = localeDAO.getLocale().getLanguage().equals("ru") ? messageSource.getRu() : messageSource.getEn();
        ClassPathResource classPathResource = new ClassPathResource(localesMessage.get("question-file"));
        InputStream resource = classPathResource.getInputStream();
        try (Reader reader = new BufferedReader(new InputStreamReader(resource))) {

            MappingStrategy<Question> strategy= new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Question.class);
            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            result = csvToBean.parse();
        }
        return result;
    }
}