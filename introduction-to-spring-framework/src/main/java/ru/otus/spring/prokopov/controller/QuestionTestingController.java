package ru.otus.spring.prokopov.controller;

import lombok.AllArgsConstructor;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.domain.Question;
import ru.otus.spring.prokopov.service.MessageQuestionService;
import ru.otus.spring.prokopov.service.PersonService;
import ru.otus.spring.prokopov.service.QuestionService;

@AllArgsConstructor
public class QuestionTestingController implements  TestingController{

    private final QuestionService questionService;
    private final PersonService personService;
    private final MessageQuestionService messageQuestionService;
    private final ConsoleView consoleView;

    @Override
    public void execute() {
        questionService.startQuestionSession(personService.getLastSave());
        while (questionService.existNextQuestion()) {
            Question question = questionService.getNextQuestion();
            consoleView.outputConsole(messageQuestionService.getBodyMessage(question));
            consoleView.outputConsole(messageQuestionService.getAdditionalMessage(question));
            String answer = consoleView.inputConsole();
            if(questionService.correctAnswer(answer)) {
                consoleView.outputConsole("Correct answer!");
            } else {
                consoleView.outputConsole("Wrong answer!");
            }
        }
        String result = new StringBuilder()
                .append("Your result: ")
                .append(questionService.endQuestionSession())
                .append(" correct answers.")
                .toString();
        consoleView.outputConsole(result);
    }
}
