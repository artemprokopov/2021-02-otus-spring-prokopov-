package ru.otus.spring.prokopov.consoleview;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
public class LogoConsoleView implements ConsoleView {

    @Override
    public String inputConsole() {
        throw new NotImplementedException("LogoConsoleView не поддерживает консольный ввод!!!");
    }

    @Override
    public void outputConsole(String outputString) {
        System.out.println(outputString);
    }
}
