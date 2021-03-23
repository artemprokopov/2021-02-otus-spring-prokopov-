package ru.otus.spring.prokopov.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.domain.Question;
import ru.otus.spring.prokopov.service.LocaleService;
import ru.otus.spring.prokopov.service.MessageQuestionService;
import ru.otus.spring.prokopov.service.PersonService;
import ru.otus.spring.prokopov.service.QuestionService;

@Service
public class QuestionTestingController implements  TestingController{

    private final QuestionService questionService;
    private final PersonService personService;
    private final MessageQuestionService messageQuestionService;
    private final ConsoleView consoleView;
    private final MessageSource messageSource;
    private final LocaleService localeService;


    public QuestionTestingController(QuestionService questionService,
                                     PersonService personService,
                                     MessageQuestionService messageQuestionService,
                                     @Qualifier("testingConsoleView") ConsoleView consoleView,
                                     MessageSource messageSource,
                                     LocaleService localeService) {
        this.questionService = questionService;
        this.personService = personService;
        this.messageQuestionService = messageQuestionService;
        this.consoleView = consoleView;
        this.messageSource = messageSource;
        this.localeService = localeService;
    }

    @Override
    public void execute() {
        questionService.startQuestionSession(personService.getLastSave());
        while (questionService.existNextQuestion()) {
            Question question = questionService.getNextQuestion();
            consoleView.outputConsole(messageQuestionService.getBodyMessage(question));
            consoleView.outputConsole(messageQuestionService.getAdditionalMessage(question));
            String answer = consoleView.inputConsole();
            if(questionService.correctAnswer(answer)) {
                consoleView.outputConsole(messageSource.getMessage("correct.answer", null, localeService.getCurrentLocale()));
            } else {
                consoleView.outputConsole(messageSource.getMessage("wrong.answer", null, localeService.getCurrentLocale()));
            }
        }
        int numberCorrectAnswer = questionService.endQuestionSession();
        String result = messageSource.getMessage("result", new Object[]{numberCorrectAnswer}, localeService.getCurrentLocale());
        consoleView.outputConsole(result);

        int minimumCorrectAnswerForPassedTest = Integer.
                parseInt(messageSource.getMessage("minimum.point", null, localeService.getCurrentLocale()));
        String testResult = messageSource
                .getMessage("tested.result", new Object[]{minimumCorrectAnswerForPassedTest}, localeService.getCurrentLocale());
        consoleView.outputConsole(testResult);
        if (numberCorrectAnswer >= minimumCorrectAnswerForPassedTest) {
            consoleView.outputConsole(messageSource.getMessage("test.passed", null, localeService.getCurrentLocale()));
        } else {
            consoleView.outputConsole(messageSource.getMessage("test.failed", null, localeService.getCurrentLocale()));
        }
    }
}
