package ru.otus.spring.prokopov.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.prokopov.domain.LocaleSettings;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class LocaleDaoImpl implements LocaleDAO{

    private final LocaleSettings localeSettings;

    @Override
    public Locale getLocale() {
        return localeSettings.getLocale();
    }

    @Override
    public void saveLocale(Locale locale) {
        localeSettings.setLocale(locale);
    }
}
