package ru.otus.spring.prokopov.controller;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.domain.Question;
import ru.otus.spring.prokopov.service.MessageQuestionService;
import ru.otus.spring.prokopov.service.MessageService;
import ru.otus.spring.prokopov.service.PersonService;
import ru.otus.spring.prokopov.service.PointService;
import ru.otus.spring.prokopov.service.QuestionService;

@AllArgsConstructor
@Controller
public class QuestionTestingController implements  TestingController{

    private final QuestionService questionService;
    private final PersonService personService;
    private final MessageQuestionService messageQuestionService;
    private final ConsoleView consoleView;
    private final MessageService messageService;
    private final PointService pointService;

    @Override
    public void execute() {
        questionService.startQuestionSession(personService.getLastSave());
        while (questionService.existNextQuestion()) {
            Question question = questionService.getNextQuestion();
            consoleView.outputConsole(messageQuestionService.getBodyMessage(question));
            consoleView.outputConsole(messageQuestionService.getAdditionalMessage(question));
            String answer = consoleView.inputConsole();
            if(questionService.correctAnswer(answer)) {
                consoleView.outputConsole(messageService.getMessage("answer-correct"));
            } else {
                consoleView.outputConsole(messageService.getMessage("answer-wrong"));
            }
        }
        int numberCorrectAnswer = questionService.endQuestionSession();
        String result = String.format(messageService.getMessage("answer-result"), numberCorrectAnswer);
        consoleView.outputConsole(result);

        int minimumCorrectAnswerForPassedTest = pointService.getMinPointsForPassedTest();
        String testResult = String.format(messageService.getMessage("test-result"), minimumCorrectAnswerForPassedTest);
        consoleView.outputConsole(testResult);
        if (numberCorrectAnswer >= minimumCorrectAnswerForPassedTest) {
            consoleView.outputConsole(messageService.getMessage("test-passed"));
        } else {
            consoleView.outputConsole(messageService.getMessage("test-failed"));
        }
    }
}
