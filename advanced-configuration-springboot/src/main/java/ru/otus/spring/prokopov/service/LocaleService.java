package ru.otus.spring.prokopov.service;

import java.util.Locale;

public interface LocaleService {

    Locale getCurrentLocale();
    void setCurrentLocale(Locale locale);
}
