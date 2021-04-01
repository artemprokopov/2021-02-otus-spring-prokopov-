package ru.otus.spring.prokopov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.configuration.MessageSource;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(MessageSource.class)
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;
    private final LocaleService localeService;

    @Override
    public String getMessage(String key) {
        Map<String, String> localesMessage = localeService.getCurrentLocale().getLanguage().equals("ru") ? messageSource.getRu() : messageSource.getEn();
        String message = Optional.ofNullable(localesMessage).orElse(messageSource.getEn()).get(key);
        return Optional.ofNullable(message).orElse("");
    }
}
