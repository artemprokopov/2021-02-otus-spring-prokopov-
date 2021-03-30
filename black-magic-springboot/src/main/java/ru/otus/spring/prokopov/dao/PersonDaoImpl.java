package ru.otus.spring.prokopov.dao;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.otus.spring.prokopov.domain.Person;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonDaoImpl implements PersonDao {

    private final Map<String,Person> personStorage = new HashMap<>();

    @Override
    public Person getByFirstNameAndSecondName(@NonNull final String firstName, @NonNull final String secondName) {
        String fullName = new StringBuilder()
                .append(firstName.trim())
                .append(" ")
                .append(secondName.trim())
                .toString();
        return personStorage.get(fullName);
    }

    @Override
    public Person load(@NonNull final Person person) {
         String fullName = new StringBuilder()
                .append(person.getFirstName().trim())
                .append(" ")
                .append(person.getSecondName().trim())
                .toString();
         return personStorage.get(fullName);
    }

    @Override
    public void save(@NonNull final Person person) {
        String fullName = new StringBuilder()
                .append(person.getFirstName().trim())
                .append(" ")
                .append(person.getSecondName().trim())
                .toString();

        personStorage.put(fullName, person);
    }
}
