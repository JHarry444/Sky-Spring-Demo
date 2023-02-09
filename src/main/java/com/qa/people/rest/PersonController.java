package com.qa.people.rest;

import com.qa.people.entities.Person;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody @Valid Person person) { // pull person from the body of the req
  }


    @GetMapping("/getAll")
    public List<Person> getAll() {

    }


    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable int id) { // pulls id from the path (url)

    }

    @PatchMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id, @PathParam("name") String name, @PathParam("age") Integer age, @PathParam("job") String job) {

    }


    @DeleteMapping("/remove/{id}")
    public Person removePerson(@PathVariable int id) {

    }


}
