/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.otus.spring.prokopov.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Artem Prokopov
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"age", "testResult"})
public class Person {
    private  String firstName;
    private  String secondName;
    private  int age;
    private  int testResult;

    Person putTestResult(final int scoreTest) {
        return new Person(firstName, secondName, age, scoreTest);
    }
}
