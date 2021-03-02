package ru.otus.spring.prokopov.service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.prokopov.dao.PersonDao;
import ru.otus.spring.prokopov.domain.Person;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private Person lastSavePerson;

    @Override
    public Person getPerson(String firstName, String secondName) {
        return personDao.getByFirstNameAndSecondName(firstName, secondName);
    }

    @Override
    public Person getPerson(Person person) {
        return personDao.load(person);
    }

    @Override
    public Person getLastSave() {
        return lastSavePerson;
    }

    @Override
    public void savePerson(Person person) {
        lastSavePerson = person;
        personDao.save(person);
    }
}
