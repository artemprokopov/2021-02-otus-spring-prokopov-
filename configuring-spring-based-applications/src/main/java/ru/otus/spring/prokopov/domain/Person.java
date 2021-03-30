package ru.otus.spring.prokopov.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"age", "testResult"})
public class Person {
    private  String firstName;
    private  String secondName;
    private  int age;
    private  int testResult;
}
