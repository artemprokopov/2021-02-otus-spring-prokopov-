package ru.otus.spring.prokopov.controller;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainTestingController implements TestingController {

    private final TestingController logoController;
    private final TestingController registrationController;
    private final TestingController questionController;

    @Override
    public void execute() {
        logoController.execute();
        registrationController.execute();
        questionController.execute();
    }
}
