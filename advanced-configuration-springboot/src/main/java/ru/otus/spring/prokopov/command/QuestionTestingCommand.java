package ru.otus.spring.prokopov.command;

import lombok.AllArgsConstructor;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.domain.Question;
import ru.otus.spring.prokopov.service.MessageQuestionService;
import ru.otus.spring.prokopov.service.MessageService;
import ru.otus.spring.prokopov.service.PersonService;
import ru.otus.spring.prokopov.service.PointService;
import ru.otus.spring.prokopov.service.QuestionService;

@AllArgsConstructor
@ShellComponent
public class QuestionTestingCommand {

    private final QuestionService questionService;
    private final PersonService personService;
    private final MessageQuestionService messageQuestionService;
    private final ConsoleView consoleView;
    private final MessageService messageService;
    private final PointService pointService;

    @ShellMethod(value = "Start test", group = "Test")
    public void startTest() {
        if (personService.getLastSave() == null ) {
            consoleView.outputConsole(messageService.getMessage("not-registration"));
            return;
        }
        questionService.startQuestionSession(personService.getLastSave());
    }
    @ShellMethod(value = "Get next question", group = "Test")
    public void nextQuestion() {
        if (personService.getLastSave() == null ) {
            consoleView.outputConsole(messageService.getMessage("not-registration"));
            return;
        }
        if (!questionService.isStartSession()) {
            consoleView.outputConsole(messageService.getMessage("not-start"));
            return;
        }
        if (questionService.existNextQuestion()) {
            Question question = questionService.getNextQuestion();
            consoleView.outputConsole(messageQuestionService.getBodyMessage(question));
            consoleView.outputConsole(messageQuestionService.getAdditionalMessage(question));
            String answer = consoleView.inputConsole();
            if(questionService.correctAnswer(answer)) {
                consoleView.outputConsole(messageService.getMessage("answer-correct"));
            } else {
                consoleView.outputConsole(messageService.getMessage("answer-wrong"));
            }
        } else {
            consoleView.outputConsole(messageService.getMessage("test-completed"));
        }
    }

    @ShellMethod(value = "View results", group = "Test")
    public void result() {
        if (personService.getLastSave() == null ) {
            consoleView.outputConsole(messageService.getMessage("not-registration"));
            return;
        }
        if (!questionService.existNextQuestion()) {
            int numberCorrectAnswer = questionService.resultQuestionSession();
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
        } else {
            consoleView.outputConsole(messageService.getMessage("test-not-completed"));
        }
    }

    @ShellMethod(value = "Restart test", group = "Test")
    public void restartTest() {
        questionService.restartSession();
    }
}
