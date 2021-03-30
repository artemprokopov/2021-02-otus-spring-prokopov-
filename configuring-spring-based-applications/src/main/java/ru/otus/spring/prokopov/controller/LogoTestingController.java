package ru.otus.spring.prokopov.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.consoleview.ConsoleView;

@PropertySource("classpath:logo.properties")
@Service
public class LogoTestingController implements TestingController {

    private final ConsoleView consoleViewOutput;
    private final String resource;

    public LogoTestingController(@Qualifier("testingConsoleView") ConsoleView consoleViewOutput,
                                 @Value("${logo}") String resource) {
        this.consoleViewOutput = consoleViewOutput;
        this.resource = resource;
    }

    @Override
    public void execute() {
        consoleViewOutput.outputConsole(resource);
    }
}
