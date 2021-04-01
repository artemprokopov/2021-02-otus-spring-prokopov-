package ru.otus.spring.prokopov;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring.prokopov.controller.MainTestingController;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {

    private final MainTestingController mainTestingController;

    public static void main(String[] args)  {
         SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainTestingController.execute();
    }
}
