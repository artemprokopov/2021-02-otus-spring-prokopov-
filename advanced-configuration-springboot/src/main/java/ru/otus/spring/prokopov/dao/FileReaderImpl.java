package ru.otus.spring.prokopov.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import ru.otus.spring.prokopov.configuration.MessageSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

@RequiredArgsConstructor
@Component
@EnableConfigurationProperties(MessageSource.class)
public class FileReaderImpl implements FileReader{

    private final MessageSource messageSource;
    private final LocaleDAO localeDAO;

    @Override
    public Reader getFileReade() throws IOException {
        Map<String, String> localesMessage = localeDAO.getLocale().getLanguage().equals("ru") ? messageSource.getRu() : messageSource.getEn();
        ClassPathResource classPathResource = new ClassPathResource(localesMessage.get("question-file"));
        InputStream resource = classPathResource.getInputStream();
        Reader reader = new BufferedReader(new InputStreamReader(resource));
        return reader;
    }
}
