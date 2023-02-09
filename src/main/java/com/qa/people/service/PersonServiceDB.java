package com.qa.people.service;

import com.qa.people.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;


//@Service
public class PersonServiceDB implements PersonService{
    @Override
    public Person createPerson(Person p) {
        return null;
    }

    @Override
    public Person getById(int id) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person update(int id, String name, Integer age, String job) {
        return null;
    }

    @Override
    public Person remove(int id) {
        return null;
    }
}
