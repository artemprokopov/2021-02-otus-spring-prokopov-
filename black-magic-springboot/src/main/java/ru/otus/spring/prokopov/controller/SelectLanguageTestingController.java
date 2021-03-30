package ru.otus.spring.prokopov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.service.LocaleService;
import ru.otus.spring.prokopov.service.MessageService;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class SelectLanguageTestingController implements TestingController {

    private final ConsoleView consoleView;
    private final LocaleService localeService;
    private final MessageService messageService;

    @Override
    public void execute() {
        consoleView.outputConsole(messageService.getMessage("select"));
        consoleView.outputConsole(messageService.getMessage("select-lang-En"));
        consoleView.outputConsole(messageService.getMessage("select-lang-Ru"));
        String result = consoleView.inputConsole();
        if (result.equalsIgnoreCase("1")) {
            localeService.setCurrentLocale(new Locale("en", "EN"));
        } else if ((result.equalsIgnoreCase("2"))) {
            localeService.setCurrentLocale(new Locale("ru", "RU"));
        } else {
            localeService.setCurrentLocale(Locale.ROOT);
        }
        consoleView.outputConsole(localeService.getCurrentLocale().toString());
    }
}
