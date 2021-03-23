package ru.otus.spring.prokopov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.consoleview.ConsoleView;
import ru.otus.spring.prokopov.service.LocaleService;

import java.util.Locale;


@PropertySource("classpath:selectlang.properties")
@Service
public class SelectLanguageTestingController implements TestingController {

    private final ConsoleView consoleView;
    private final LocaleService localeService;

    @Value("${select}") private String languageSelect;
    @Value("${language.ru}") private String languageRu;
    @Value("${language.en}") private String languageEn;

    @Autowired
    public SelectLanguageTestingController(@Qualifier("testingConsoleView") ConsoleView consoleView,
                                           LocaleService localeService) {
        this.consoleView = consoleView;
        this.localeService = localeService;
    }

    @Override
    public void execute() {
        consoleView.outputConsole(languageSelect);
        consoleView.outputConsole(languageEn);
        consoleView.outputConsole(languageRu);
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
