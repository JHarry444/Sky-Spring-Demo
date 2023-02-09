package com.qa.people.persistence;

import com.qa.people.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo  extends JpaRepository<Person, Integer> {

}
