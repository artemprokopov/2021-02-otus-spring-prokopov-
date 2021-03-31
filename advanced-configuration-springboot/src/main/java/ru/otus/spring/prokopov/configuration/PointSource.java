package ru.otus.spring.prokopov.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "min")
public class PointSource {
    private Integer  point;
}
