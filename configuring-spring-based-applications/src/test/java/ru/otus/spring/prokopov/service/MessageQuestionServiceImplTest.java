package ru.otus.spring.prokopov.service;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.otus.spring.prokopov.domain.Question;

import static org.junit.jupiter.api.Assertions.*;

class MessageQuestionServiceImplTest {

    static Question question;

    @BeforeAll
    static void createQuestion() {
        ArrayListValuedHashMap<String, String> answer0 = new ArrayListValuedHashMap<>();
        answer0.put("answerChoice1", "Джон Кеннеди");
        answer0.put("answerChoice2", "Франклин Рузвельт");
        answer0.put("answerChoice3", "Рональд Рейган");
        question = new Question("Кто из президентов США написал свой собственный рассказ про Шерлока Холмса?(выберите номер правильного ответа)"
                ,"2"
                , answer0);
    }

    @Test
    void getBodyMessage() {
        String except = "Кто из президентов США написал свой собственный рассказ про Шерлока Холмса?(выберите номер правильного ответа)";
        MessageQuestionService messageQuestionService = new MessageQuestionServiceImpl();
        assertEquals(except, messageQuestionService.getBodyMessage(question));
    }

    @Test
    void getAdditionalMessage() {
        String except = "1. Джон Кеннеди" + System.lineSeparator()
                + "2. Франклин Рузвельт" + System.lineSeparator()
                + "3. Рональд Рейган";
        MessageQuestionService messageQuestionService = new MessageQuestionServiceImpl();
        assertEquals(except, messageQuestionService.getAdditionalMessage(question));
    }
}