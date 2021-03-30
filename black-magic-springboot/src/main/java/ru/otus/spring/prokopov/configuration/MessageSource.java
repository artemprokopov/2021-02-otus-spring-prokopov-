package ru.otus.spring.prokopov.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "locales")
@Data
public class MessageSource {
        private Map<String, String> en = new HashMap<>();
        private Map<String, String> ru = new HashMap<>();
}
