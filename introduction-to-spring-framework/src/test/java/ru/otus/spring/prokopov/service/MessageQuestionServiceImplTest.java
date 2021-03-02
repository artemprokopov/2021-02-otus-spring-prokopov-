package ru.otus.spring.prokopov.service;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.prokopov.domain.Question;

import static org.junit.jupiter.api.Assertions.*;
class MessageQuestionServiceImplTest {

    private ArrayListValuedHashMap<String, String> answer0 = new ArrayListValuedHashMap<>();
    {answer0.put("answerChoice1", "John F.Kennedy");
    answer0.put("answerChoice2", "Franklin Roosevelt");
    answer0.put("answerChoice3", "Ronald Reagan");}
    private Question question0 = new Question("Which us President wrote his own Sherlock Holmes story?(choose the correct answer number)"
            ,"2"
            , answer0);

    @Test
    @DisplayName("Получаем тело вопроса")
    void getBodyMessage() {
        MessageQuestionService messageQuestionService = new MessageQuestionServiceImpl();

        String bodyMessageQuestion = messageQuestionService.getBodyMessage(question0);

        String expectation = "Which us President wrote his own Sherlock Holmes story?(choose the correct answer number)";

        assertEquals(bodyMessageQuestion, expectation);
    }

    @Test
    @DisplayName("Получаем варианты ответов")
    void getAdditionalMessage() {
        MessageQuestionService messageQuestionService = new MessageQuestionServiceImpl();

        String bodyMessageQuestion = messageQuestionService.getAdditionalMessage(question0);

        String expectation = "1. " +
                "John F.Kennedy"+
                System.lineSeparator() +
                "2. " +
                "Franklin Roosevelt" +
                System.lineSeparator() +
                "3. " +
                "Ronald Reagan";

        assertEquals(bodyMessageQuestion, expectation);
    }
}