package ru.otus.spring.prokopov.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class MainTestingController implements TestingController {

    private final SelectLanguageTestingController selectLanguageTestingController;
    private final RegistrationTestingController registrationTestingController;
    private final QuestionTestingController questionTestingController;

    @Override
    public void execute() {
        selectLanguageTestingController.execute();
        registrationTestingController.execute();
        questionTestingController.execute();
    }
}
