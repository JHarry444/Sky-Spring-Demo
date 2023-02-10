package com.qa.people.rest;

import com.qa.people.dto.PersonDTO;
import com.qa.people.entities.Person;
import com.qa.people.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PersonController {

    // the service variable is a dependency
//    @Autowired  -> also injects the dependency but isn't as good as contructor injection
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody @Valid Person person) { // pull person from the body of the req
        return this.service.createPerson(person);
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/get/{id}")
    public PersonDTO getPerson(@PathVariable int id) { // pulls id from the path (url)
        Person found = this.service.getById(id);
        PersonDTO dto = new PersonDTO(found.getName(), found.getAge(), found.getJob());

        return dto;
    }

    @PatchMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id, @PathParam("name") String name, @PathParam("age") Integer age, @PathParam("job") String job) {
        return this.service.update(id, name, age, job);
    }

    @DeleteMapping("/remove/{id}")
    public Person removePerson(@PathVariable int id) {
        return this.service.remove(id);
    }

}
