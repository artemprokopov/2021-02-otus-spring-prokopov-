package ru.otus.spring.prokopov.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Getter
@Setter
@Component
public class LocaleSettings {
    private Locale locale = Locale.ROOT;
}
