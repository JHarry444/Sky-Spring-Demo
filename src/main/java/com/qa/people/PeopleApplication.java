package com.qa.people;

import com.qa.people.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.IntStream;

@SpringBootApplication
public class PeopleApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(PeopleApplication.class, args);
		// DEMO PURPOSES ONLY - PLZ DO NOT STEAL
	}

}
