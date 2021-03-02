package ru.otus.spring.prokopov.domain;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.MultiValuedMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Question {
    @CsvBindByName(column = "question")
    private String question;
    @CsvBindByName(column = "answer")
    private String  answer;
    @CsvBindAndJoinByName(column = "answerChoice[1-9]+", elementType = String.class)
    private MultiValuedMap<String, String> answerChoice;
}
