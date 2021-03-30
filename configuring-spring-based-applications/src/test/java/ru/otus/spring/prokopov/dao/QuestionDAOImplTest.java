package ru.otus.spring.prokopov.dao;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring.prokopov.domain.Question;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


class QuestionDAOImplTest {

    @DisplayName("Проверяем чтение вопросов из csv файла")
    @Test
    void getAllQuestion() throws IOException {
        Locale locale = new Locale("en", "EN");

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames( "classpath:questions");
        messageSource.setDefaultEncoding("UTF-8");

        LocaleDAO localeDAO = new LocaleDaoImpl();
        localeDAO.saveLocale(locale);

        QuestionDAO questionDAO = new QuestionDAOImpl(messageSource, localeDAO);

        ArrayListValuedHashMap<String, String> answer0 = new ArrayListValuedHashMap<>();
        answer0.put("answerChoice1", "John F.Kennedy");
        answer0.put("answerChoice2", "Franklin Roosevelt");
        answer0.put("answerChoice3", "Ronald Reagan");
        Question question0 = new Question("Which us President wrote his own Sherlock Holmes story?(choose the correct answer number)"
                ,"2"
                , answer0);

        ArrayListValuedHashMap<String, String> answer1 = new ArrayListValuedHashMap<>();
        answer1.put("answerChoice1", "None");
        answer1.put("answerChoice2", "None");
        answer1.put("answerChoice3", "None");
        Question question1 = new Question("Berry bright crimson color?(Write the answer in one word)"
                ,"Raspberry"
                , answer1);

        ArrayListValuedHashMap<String, String> answer2 = new ArrayListValuedHashMap<>();
        answer2.put("answerChoice1", "None");
        answer2.put("answerChoice2", "None");
        answer2.put("answerChoice3", "None");
        Question question2 = new Question("Same as muscle?(Write the answer in one word)"
                ,"Muscle"
                , answer2);

        ArrayListValuedHashMap<String, String> answer3 = new ArrayListValuedHashMap<>();
        answer3.put("answerChoice1", "parasitism tax");
        answer3.put("answerChoice2", "cowardice tax");
        answer3.put("answerChoice3", "tax on the absence of boots");
        Question question3 = new Question("What duty was introduced in the twelfth century in England to force men to go to war?(choose the correct answer number)"
                ,"2"
                , answer3);

        ArrayListValuedHashMap<String, String> answer4 = new ArrayListValuedHashMap<>();
        answer4.put("answerChoice1", "swimming trunks tax");
        answer4.put("answerChoice2", "palm trees tax");
        answer4.put("answerChoice3", "the sun tax");
        Question question4 = new Question("Tourists coming to Majorca are obliged to pay a tax...?(choose the correct answer number)"
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