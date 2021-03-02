package ru.otus.spring.prokopov.service;

import ru.otus.spring.prokopov.domain.Question;
import java.util.List;

public class MessageQuestionServiceImpl implements MessageQuestionService{
    @Override
    public String getBodyMessage(Question question) {
        return question.getQuestion();
    }

    @Override
    public String getAdditionalMessage(Question question) {
        String result = "";
        if (!question.getAnswerChoice().containsValue("None")) {
            result = "1. " +
                    ((List) question.getAnswerChoice().get("answerChoice1")).get(0) +
                    System.lineSeparator() +
                    "2. " +
                    ((List) question.getAnswerChoice().get("answerChoice2")).get(0) +
                    System.lineSeparator() +
                    "3. " +
                    ((List) question.getAnswerChoice().get("answerChoice3")).get(0);
        }
        return  result;
    }
}
