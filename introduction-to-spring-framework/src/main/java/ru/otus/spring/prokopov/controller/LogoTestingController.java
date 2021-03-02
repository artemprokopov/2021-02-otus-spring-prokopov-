package ru.otus.spring.prokopov.controller;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.prokopov.consoleview.ConsoleView;

@RequiredArgsConstructor
public class LogoTestingController implements TestingController {

    private final ConsoleView consoleViewOutput;
    private final String resource;

    @Override
    public void execute() {
        consoleViewOutput.outputConsole(resource);
    }
}
