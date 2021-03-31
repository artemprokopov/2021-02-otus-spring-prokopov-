package ru.otus.spring.prokopov.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.prokopov.dao.PersonDaoImpl;
import ru.otus.spring.prokopov.domain.Person;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {PersonServiceImpl.class, PersonDaoImpl.class})
class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    Person person = new Person();
    {
        person.setAge(32);
        person.setFirstName("First");
        person.setSecondName("Second");
        person.setTestResult(4);
    }

    @Test
    void getPerson() {
        Person except = personService.getPerson(person);
        assertEquals(except, person);
    }

    @Test
    void testGetPerson() {
        personService.savePerson(person);
        Person except = personService.getPerson("First", "Second");
        assertEquals(except, person);
    }

    @Test
    void getLastSave() {
        personService.savePerson(person);
        Person except = personService.getLastSave();
        assertEquals(except, person);
    }

    @Test
    void savePerson() {
        personService.savePerson(person);
        Person except = personService.getPerson(person);
        assertEquals(except, person);
    }
}