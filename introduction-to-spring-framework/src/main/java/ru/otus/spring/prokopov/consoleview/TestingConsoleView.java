package ru.otus.spring.prokopov.consoleview;

import java.util.Scanner;

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
