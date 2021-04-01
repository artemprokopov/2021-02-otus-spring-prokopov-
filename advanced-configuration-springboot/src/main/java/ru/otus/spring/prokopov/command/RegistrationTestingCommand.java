package ru.otus.spring.prokopov.command;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.domain.Person;
import ru.otus.spring.prokopov.service.MessageService;
import ru.otus.spring.prokopov.service.PersonService;

@RequiredArgsConstructor
@ShellComponent
public class RegistrationTestingCommand  {

    private final PersonService personService;
    private final ConsoleView consoleView;
    private final MessageService messageService;

    @ShellMethod(value = "Registration")
    public void registration() {
        consoleView.outputConsole(messageService.getMessage("registration-greeting"));
        consoleView.outputConsole(messageService.getMessage("registration-promptedEnterFirstName"));
        String firstName = consoleView.inputConsole();

        consoleView.outputConsole(messageService.getMessage("registration-promptedEnterSecondName"));
        String secondName = consoleView.inputConsole();

        boolean nonNumber = true;
        int age = 0;
        while (nonNumber) {
            consoleView.outputConsole(messageService.getMessage("registration-promptedEnterAge"));
            String inputAge = consoleView.inputConsole();
            try {
                age = Integer.parseInt(inputAge);
                nonNumber = false;
            } catch (NumberFormatException nfex) {
                consoleView.outputConsole(messageService.getMessage("registration-notNumberError"));
            }
        }

        Person person = new Person(firstName, secondName, age, 0);
        personService.savePerson(person);
    }
}
