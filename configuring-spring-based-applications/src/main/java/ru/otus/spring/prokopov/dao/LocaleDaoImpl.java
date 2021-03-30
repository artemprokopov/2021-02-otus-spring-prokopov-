package ru.otus.spring.prokopov.dao;

import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.domain.LocaleSettings;

import java.util.Locale;

@Service
public class LocaleDaoImpl implements LocaleDAO{

    private final LocaleSettings localeSettings = new LocaleSettings();

    @Override
    public Locale getLocale() {
        return localeSettings.getLocale();
    }

    @Override
    public void saveLocale(Locale locale) {
        localeSettings.setLocale(locale);
    }
}
