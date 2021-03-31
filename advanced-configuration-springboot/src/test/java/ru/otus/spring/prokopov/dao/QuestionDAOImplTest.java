package ru.otus.spring.prokopov.dao;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.prokopov.domain.LocaleSettings;
import ru.otus.spring.prokopov.domain.Question;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = {LocaleDaoImpl.class, LocaleSettings.class, QuestionDAOImpl.class})
class QuestionDAOImplTest {

    @Autowired
    private  LocaleDAO localeDAO;
    @Autowired
    private  QuestionDAO questionDAO;

    @DisplayName("Проверяем чтение вопросов из csv файла")
    @Test
    void getAllQuestion() throws IOException {

        localeDAO.saveLocale(new Locale("ru", "RU"));

        ArrayListValuedHashMap<String, String> answer0 = new ArrayListValuedHashMap<>();
        answer0.put("answerChoice1", "Джон Кеннеди");
        answer0.put("answerChoice2", "Франклин Рузвельт");
        answer0.put("answerChoice3", "Рональд Рейган");
        Question question0 = new Question("Кто из президентов США написал свой собственный рассказ про Шерлока Холмса?(выберите номер правильного ответа)"
                        ,"2"
                        , answer0);

        ArrayListValuedHashMap<String, String> answer1 = new ArrayListValuedHashMap<>();
        answer1.put("answerChoice1", "None");
        answer1.put("answerChoice2", "None");
        answer1.put("answerChoice3", "None");
        Question question1 = new Question("Ягода ярко-малинового цвета?(Напишите ответ одним словом)"
                ,"Малина"
                , answer1);

        ArrayListValuedHashMap<String, String> answer2 = new ArrayListValuedHashMap<>();
        answer2.put("answerChoice1", "None");
        answer2.put("answerChoice2", "None");
        answer2.put("answerChoice3", "None");
        Question question2 = new Question("То же, что и мышца?(Напишите ответ одним словом)"
                ,"Мускул"
                , answer2);

        ArrayListValuedHashMap<String, String> answer3 = new ArrayListValuedHashMap<>();
        answer3.put("answerChoice1", "Налог на тунеядство");
        answer3.put("answerChoice2", "Налог на трусость");
        answer3.put("answerChoice3", "Налог на отсутствие сапог");
        Question question3 = new Question("Какую пошлину ввели в XII  веке в Англии для того чтобы заставить мужчин пойти на войну?(выберите номер правильного ответа)"
                ,"2"
                , answer3);

        ArrayListValuedHashMap<String, String> answer4 = new ArrayListValuedHashMap<>();
        answer4.put("answerChoice1", "На плавки");
        answer4.put("answerChoice2", "На пальмы");
        answer4.put("answerChoice3", "На солнце");
        Question question4 = new Question("Туристы, приезжающие на Майорку, обязаны заплатить налог…?(выберите номер правильного ответа)"
                ,"3"
                , answer4);

        Question[] questions = {
            question0,
            question1,
            question2,
            question3,
            question4
        };

        List<Question> questionList = questionDAO.getAllQuestion();

        assertThat(questionList).contains(questions);
    }
}