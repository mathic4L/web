package ru.spring.dao;

import org.springframework.stereotype.Component;
import ru.spring.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private static int counter = 0;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++counter, "a"));
        people.add(new Person(++counter, "b"));
        people.add(new Person(++counter, "c"));
    }

    public List<Person> people() {
        return people;
    }
    public Person get(int id) {
        return people.stream().filter(x->x.getId() == id).findAny().orElse(null);
    }
    public void add(Person person) {
        person.setId(++counter);
        people.add(person);
    }
    public boolean update(int id, Person newPerson) {
        if (people.removeIf(x->x.getId() == id)) {
            newPerson.setId(++counter);
            people.add(newPerson);
            return true;
        } else {
            return false;
        }
    }
    public boolean delete(int id) {
        return people.removeIf(x->x.getId() == id);
    }
}

