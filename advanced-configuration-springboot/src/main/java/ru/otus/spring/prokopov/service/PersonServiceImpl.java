package ru.otus.spring.prokopov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.prokopov.dao.PersonDao;
import ru.otus.spring.prokopov.domain.Person;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

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
        return personDao.loadLast();
    }

    @Override
    public void savePerson(Person person) {
        personDao.save(person);
    }
}
