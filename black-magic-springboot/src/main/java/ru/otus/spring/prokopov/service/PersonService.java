package ru.otus.spring.prokopov.service;

import ru.otus.spring.prokopov.domain.Person;

public interface PersonService {
    Person getPerson(String firstName, String secondName);
    Person getPerson(Person person);
    Person getLastSave();
    void savePerson(Person person);
}
