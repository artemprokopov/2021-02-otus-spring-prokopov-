package ru.otus.spring.prokopov.consoleview;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

@NoArgsConstructor
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
