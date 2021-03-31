package ru.otus.spring.prokopov;

import lombok.RequiredArgsConstructor;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

@SpringBootApplication
@RequiredArgsConstructor
public class Main  {

    public static void main(String[] args)  {
         SpringApplication.run(Main.class, args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("test:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
    }
}
