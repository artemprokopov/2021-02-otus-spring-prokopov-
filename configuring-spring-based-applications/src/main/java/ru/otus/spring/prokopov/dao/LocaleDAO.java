package ru.otus.spring.prokopov.dao;

import java.util.Locale;

public interface LocaleDAO {
    Locale getLocale();
    void saveLocale(Locale locale);
}
