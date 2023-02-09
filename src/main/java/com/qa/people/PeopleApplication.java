package com.qa.people;

import com.qa.people.rest.PersonController;
import com.qa.people.service.PersonServiceDB;
import com.qa.people.service.PersonServiceList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleApplication.class, args);
		// DEMO PURPOSES ONLY - PLZ DO NOT STEAL
		new PersonController(new PersonServiceList());
		new PersonController(new PersonServiceDB());
	}

}
