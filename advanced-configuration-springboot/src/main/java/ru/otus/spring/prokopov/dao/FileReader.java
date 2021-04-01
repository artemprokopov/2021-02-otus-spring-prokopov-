package ru.otus.spring.prokopov.dao;

import java.io.IOException;
import java.io.Reader;

public interface FileReader {
    Reader getFileReade() throws IOException;
}
