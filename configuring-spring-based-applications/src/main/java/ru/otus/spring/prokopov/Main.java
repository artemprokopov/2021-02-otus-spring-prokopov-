package ru.otus.spring.prokopov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.prokopov.controller.MainTestingController;

@ComponentScan
@Configuration
public class Main {

    public static void main(String[] args)  {
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Main.class);
        MainTestingController mainTestingController = applicationContext.getBean(MainTestingController.class);
        mainTestingController.execute();
    }
}
