package ru.otus.spring.prokopov.dao;

import ru.otus.spring.prokopov.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDAO {
    List<Question> getAllQuestion() throws IOException;
}
