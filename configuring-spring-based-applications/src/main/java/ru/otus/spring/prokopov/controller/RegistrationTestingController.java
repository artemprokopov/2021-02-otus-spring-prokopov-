package ru.otus.spring.prokopov.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.domain.Person;
import ru.otus.spring.prokopov.service.LocaleService;
import ru.otus.spring.prokopov.service.PersonService;

@Service
public class RegistrationTestingController implements TestingController {

    private final PersonService personService;
    private final ConsoleView consoleView;
    private final MessageSource messageSource;
    private final LocaleService localeService;

    public RegistrationTestingController(PersonService personService,
                                         @Qualifier("testingConsoleView") ConsoleView consoleView,
                                         MessageSource messageSource,
                                         LocaleService localeService) {
        this.personService = personService;
        this.consoleView = consoleView;
        this.messageSource = messageSource;
        this.localeService = localeService;
    }

    @Override
    public void execute() {
        consoleView.outputConsole(messageSource.getMessage("greeting", null, localeService.getCurrentLocale()));
        consoleView.outputConsole(messageSource.getMessage("promptedEnterFirstName", null, localeService.getCurrentLocale()));
        String firstName = consoleView.inputConsole();

        consoleView.outputConsole(messageSource.getMessage("promptedEnterSecondName", null, localeService.getCurrentLocale()));
        String secondName = consoleView.inputConsole();

        boolean nonNumber = true;
        int age = 0;
        while (nonNumber) {
            consoleView.outputConsole(messageSource.getMessage("promptedEnterAge", null, localeService.getCurrentLocale()));
            String inputAge = consoleView.inputConsole();
            try {
                age = Integer.parseInt(inputAge);
                nonNumber = false;
            } catch (NumberFormatException nfex) {
                consoleView.outputConsole(messageSource.getMessage("notNumberError", null, localeService.getCurrentLocale()));
            }
        }

        Person person = new Person(firstName, secondName, age, 0);
        personService.savePerson(person);
    }
}
