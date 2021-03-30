package ru.otus.spring.prokopov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.dao.LocaleDAO;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class LocaleServiceImpl implements LocaleService {

    private final LocaleDAO localeDAO;

    @Override
    public Locale getCurrentLocale() {
        return localeDAO.getLocale();
    }

    @Override
    public void setCurrentLocale(Locale locale) {
        localeDAO.saveLocale(locale);
    }
}
