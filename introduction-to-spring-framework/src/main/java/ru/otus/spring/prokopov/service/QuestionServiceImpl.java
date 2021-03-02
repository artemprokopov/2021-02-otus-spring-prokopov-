package ru.otus.spring.prokopov.service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.prokopov.dao.QuestionDAO;
import ru.otus.spring.prokopov.domain.Person;
import ru.otus.spring.prokopov.domain.Question;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class  QuestionServiceImpl implements QuestionService {

    private final PersonService personService;
    private final QuestionDAO questionDAO;

    private Person person;
    private Iterator<Question> questionIterator;
    private Question currentQuestion;

    private int numberOfCorrectAnswerSession = 0;

    @Override
    public void startQuestionSession(Person person) {
        List<Question> questionList = Collections.emptyList();
        numberOfCorrectAnswerSession = 0;
        this.person = personService.getPerson(person);
        try {
            questionList = questionDAO.getAllQuestion();
        } catch (IOException ioe) {
            System.out.println("Sorry, the tests not available!!!");
            System.exit(1);
        }
        questionIterator = questionList.iterator();
    }

    @Override
    public boolean existNextQuestion() {
        return questionIterator.hasNext();
    }

    @Override
    public Question getNextQuestion() {
        if (questionIterator.hasNext()) {
            currentQuestion = questionIterator.next();
        }
        return currentQuestion;
    }

    @Override
    public boolean correctAnswer(String answer) {
        boolean result = false;
        if (currentQuestion.getAnswer().equalsIgnoreCase(answer.trim())) {
            numberOfCorrectAnswerSession++;
            person.setTestResult(numberOfCorrectAnswerSession);
            result = true;
        }
        return result;
    }

    @Override
    public int endQuestionSession() {
        personService.savePerson(person);
        return person.getTestResult();
    }
}
