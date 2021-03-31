package ru.otus.spring.prokopov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.configuration.MessageSource;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(MessageSource.class)
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;
    private final LocaleService localeService;

    @Override
    public String getMessage(String key) {
        return localeService.getCurrentLocale().getLanguage().equals("ru") ?
                messageSource.getRu().get(key) : messageSource.getEn().get(key);
    }
}
