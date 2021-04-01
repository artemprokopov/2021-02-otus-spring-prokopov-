package ru.otus.spring.prokopov.service;

import ru.otus.spring.prokopov.domain.Person;
import ru.otus.spring.prokopov.domain.Question;

public interface QuestionService {
    void startQuestionSession(Person person);
    boolean existNextQuestion();
    Question getNextQuestion();
    boolean correctAnswer(String answer);
    int resultQuestionSession();
    boolean isStartSession();
    void restartSession();
}
