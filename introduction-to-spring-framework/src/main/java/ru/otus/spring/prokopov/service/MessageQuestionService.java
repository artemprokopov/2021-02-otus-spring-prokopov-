package ru.otus.spring.prokopov.service;

import ru.otus.spring.prokopov.domain.Question;

public interface MessageQuestionService {
    String getBodyMessage(Question question);
    String getAdditionalMessage(Question question);
}
