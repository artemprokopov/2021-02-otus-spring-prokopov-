package ru.otus.spring.prokopov.controller;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.domain.Person;
import ru.otus.spring.prokopov.service.PersonService;

@RequiredArgsConstructor
public class RegistrationTestingController implements TestingController {

    private final PersonService personService;
    private final ConsoleView consoleView;

    private final String greeting;
    private final String promptedEnterFirstName;
    private final String promptedEnterSecondName;
    private final String promptedEnterAge;
    private final String notNumberError;

    @Override
    public void execute() {
        consoleView.outputConsole(greeting);
        consoleView.outputConsole(promptedEnterFirstName);
        String firstName = consoleView.inputConsole();

        consoleView.outputConsole(promptedEnterSecondName);
        String secondName = consoleView.inputConsole();

        boolean nonNumber = true;
        int age = 0;
        while (nonNumber) {
            consoleView.outputConsole(promptedEnterAge);
            String inputAge = consoleView.inputConsole();
            try {
                age = Integer.parseInt(inputAge);
                nonNumber = false;
            } catch (NumberFormatException nfex) {
                consoleView.outputConsole(notNumberError);
            }
        }

        Person person = new Person(firstName, secondName, age, 0);
        personService.savePerson(person);
    }
}
