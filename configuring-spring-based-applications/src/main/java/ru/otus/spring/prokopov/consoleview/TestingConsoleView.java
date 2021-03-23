package ru.otus.spring.prokopov.consoleview;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TestingConsoleView implements ConsoleView{

    @Override
    public String inputConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void outputConsole(String outputString) {
        System.out.println(outputString);
    }
}
