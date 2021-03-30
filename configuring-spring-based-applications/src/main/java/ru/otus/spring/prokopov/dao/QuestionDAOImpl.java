package ru.otus.spring.prokopov.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionDAOImpl implements QuestionDAO {

    private final MessageSource messageSource;
    private final LocaleDAO localeDAO;

    @Override
    public List<Question> getAllQuestion() throws IOException {
        List<Question> result = Collections.emptyList();
        String pathCsvQuestionResource = messageSource.getMessage("question-file", null, localeDAO.getLocale());
        ClassPathResource classPathResource = new ClassPathResource(pathCsvQuestionResource);
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
