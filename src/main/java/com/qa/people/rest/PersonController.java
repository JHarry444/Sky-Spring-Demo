package com.qa.people.rest;

import com.qa.people.dto.PersonDTO;
import com.qa.people.dto.PersonReqDTO;
import com.qa.people.entities.Person;
import com.qa.people.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public PersonDTO addPerson(@RequestBody PersonReqDTO person) { // pull person from the body of the req
        Person toCreate = new Person(person.getFullName(), person.getOldNess(), person.getOccupation(), person.getNotNiNumber());
        Person created =  this.service.createPerson(toCreate);

        PersonDTO dto = new PersonDTO(created.getName(), created.getAge(), created.getJob());

        return dto;
    }

    @GetMapping("/getAll")
    public List<PersonDTO> getAll() {
        List<Person> found =  this.service.getAll();
        List<PersonDTO> dtos = new ArrayList<>();
//        standard for loop:
//        for (int i = 0; i < found.size(); i++) {
//            Person person = found.get(i);
//            PersonDTO dto = new PersonDTO(person.getName(), person.getAge(), person.getJob());
//            dtos.add(dto);
//        }
//      lambda version
//        return found.stream().map(p -> new PersonDTO(p.getName(), p.getAge(), p.getJob())).collect(Collectors.toList());
        // For each Person person in found:
        for (Person person : found){
            PersonDTO dto = new PersonDTO(person.getName(), person.getAge(), person.getJob());
            dtos.add(dto);
        }

        return dtos;
    }

    @GetMapping("/get/{id}")
    public PersonDTO getPerson(@PathVariable int id) { // pulls id from the path (url)
        Person found = this.service.getById(id);
        PersonDTO dto = new PersonDTO(found.getName(), found.getAge(), found.getJob());

        return dto;
    }

    @PatchMapping("/update/{id}")
    public PersonDTO updatePerson(@PathVariable int id, @PathParam("name") String name, @PathParam("age") Integer age, @PathParam("job") String job) {
        Person updated = this.service.update(id, name, age, job);

        PersonDTO dto = new PersonDTO(updated.getName(), updated.getAge(), updated.getJob());
        return dto;
    }

    @DeleteMapping("/remove/{id}")
    public PersonDTO removePerson(@PathVariable int id) {
        Person removed =  this.service.remove(id);

        PersonDTO dto = new PersonDTO(removed.getName(), removed.getAge(), removed.getJob());
        return dto;
    }

}
