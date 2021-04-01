package ru.otus.spring.prokopov.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class NumberCorrectAnswer {

    private int numberOfCorrectAnswerSession;

    public void addNumberCorrectAnswer() {
        numberOfCorrectAnswerSession++;
    }

    public int numberOfCorrectAnswerSession() {
        return numberOfCorrectAnswerSession;
    }
}
