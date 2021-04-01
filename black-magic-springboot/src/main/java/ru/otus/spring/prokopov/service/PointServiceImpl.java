package ru.otus.spring.prokopov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.configuration.PointSource;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(PointSource.class)
public class PointServiceImpl implements PointService {

    private final PointSource pointSource;

    @Override
    public int getMinPointsForPassedTest() {
        return pointSource.getPoint();
    }
}
