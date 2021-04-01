package ru.otus.spring.prokopov.dao;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import ru.otus.spring.prokopov.configuration.MessageSource;
import ru.otus.spring.prokopov.domain.Question;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Component
@EnableConfigurationProperties(MessageSource.class)
public class QuestionDAOImpl implements QuestionDAO {

    private final FileReader fileReader;

    @Override
    public List<Question> getAllQuestion() throws IOException {
        List<Question> result = Collections.emptyList();
        try (Reader reader = fileReader.getFileReade()) {
            MappingStrategy<Question> strategy= new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Question.class);
            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            result = csvToBean.parse();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }
}
