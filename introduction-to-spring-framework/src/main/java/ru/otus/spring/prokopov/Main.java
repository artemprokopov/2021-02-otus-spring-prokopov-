package ru.otus.spring.prokopov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.prokopov.controller.MainTestingController;

/**
 *@author Artem Prokopov
 */
public class Main {

    public static void main(String[] args)  {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        MainTestingController main  = applicationContext.getBean(MainTestingController.class);
        main.execute();
    }
}
