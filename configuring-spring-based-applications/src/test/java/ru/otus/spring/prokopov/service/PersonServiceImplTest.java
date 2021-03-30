package ru.otus.spring.prokopov.service;

import org.junit.jupiter.api.Test;
import ru.otus.spring.prokopov.dao.PersonDao;
import ru.otus.spring.prokopov.domain.Person;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PersonServiceImplTest {

    PersonDao personDao = mock(PersonDao.class);
    Person person = mock(Person.class);

    @Test
    void getPerson() {

        when(personDao.load(person)).thenReturn(person);

        PersonService personService = new PersonServiceImpl(personDao);
        Person except = personService.getPerson(person);
        assertEquals(except, person);
    }

    @Test
    void testGetPerson() {

        when(personDao.getByFirstNameAndSecondName("Ivan", "Ivanov")).thenReturn(person);

        PersonService personService = new PersonServiceImpl(personDao);
        Person except = personService.getPerson("Ivan", "Ivanov");
        assertEquals(except, person);
    }

    @Test
    void getLastSave() {

        PersonService personService = new PersonServiceImpl(personDao);
        personService.savePerson(person);
        Person except = personService.getLastSave();
        assertEquals(except, person);
    }

    @Test
    void savePerson() {

        when(personDao.load(person)).thenReturn(person);

        PersonService personService = new PersonServiceImpl(personDao);
        personService.savePerson(person);
        Person except = personService.getPerson(person);
        assertEquals(except, person);
    }
}