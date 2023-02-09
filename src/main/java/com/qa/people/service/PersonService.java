package com.qa.people.service;

import com.qa.people.entities.Person;

import java.util.List;

public interface PersonService {


    public abstract Person createPerson(Person p);

    Person getById(int id);

    List<Person> getAll();


    Person update(int id, String name, int age, String job);

    Person remove(int id);
}
