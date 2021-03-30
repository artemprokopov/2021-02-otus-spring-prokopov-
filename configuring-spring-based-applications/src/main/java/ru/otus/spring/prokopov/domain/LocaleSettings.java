package ru.otus.spring.prokopov.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class LocaleSettings {
    private Locale locale = Locale.ROOT;
}
