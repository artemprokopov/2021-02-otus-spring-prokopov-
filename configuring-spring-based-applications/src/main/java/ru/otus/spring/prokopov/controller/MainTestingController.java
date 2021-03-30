package ru.otus.spring.prokopov.controller;

import org.springframework.stereotype.Service;

@Service
public class MainTestingController implements TestingController {

    private final LogoTestingController logoTestingController;
    private final SelectLanguageTestingController selectLanguageTestingController;
    private final RegistrationTestingController registrationTestingController;
    private final QuestionTestingController questionTestingController;

    public MainTestingController(LogoTestingController logoTestingController,
                                 SelectLanguageTestingController selectLanguageTestingController,
                                 RegistrationTestingController registrationTestingController,
                                 QuestionTestingController questionTestingController) {
        this.logoTestingController = logoTestingController;
        this.selectLanguageTestingController = selectLanguageTestingController;
        this.registrationTestingController = registrationTestingController;
        this.questionTestingController = questionTestingController;
    }



    @Override
    public void execute() {
        logoTestingController.execute();
        selectLanguageTestingController.execute();
        registrationTestingController.execute();
        questionTestingController.execute();
    }
}
