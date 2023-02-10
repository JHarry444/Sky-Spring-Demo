package com.qa.people.service;

import com.qa.people.entities.Person;
import com.qa.people.exceptions.PersonNotFoundException;
import com.qa.people.persistence.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceDB implements PersonService {

    private PersonRepo repo;

    public PersonServiceDB(PersonRepo repo) {
        this.repo = repo;
    }

    @Override
    public Person createPerson(Person p) {
        return this.repo.save(p);
    }

    @Override
    public Person getById(int id) {
        // returns Person if it's found or throws the exception if it isn't
        return this.repo.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }

    @Override
    public List<Person> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Person update(int id, String name, Integer age, String job) {
        Person old = this.getById(id);

        if (name != null) old.setName(name);
        if (age != null) old.setAge(age);
        if (job != null) old.setJob(job);


        return this.repo.save(old);
    }

    @Override
    public Person remove(int id) {
        Person existing = this.getById(id);
        this.repo.deleteById(id); // actually does the delete
        return existing;
    }
}
