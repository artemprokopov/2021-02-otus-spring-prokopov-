package ru.otus.spring.prokopov.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"age", "testResult"})
@Component
public class Person {
    private  String firstName;
    private  String secondName;
    private  int age;
    private  int testResult;
}
