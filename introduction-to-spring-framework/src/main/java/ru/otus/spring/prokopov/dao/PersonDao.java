package ru.otus.spring.prokopov.dao;

import ru.otus.spring.prokopov.domain.Person;

/**
 *
 * @author smetchik
 */
public interface PersonDao {
    Person getByFirstNameAndSecondName(String firstName, String secondName);
    Person load(Person person);
    void save(Person person);
}
