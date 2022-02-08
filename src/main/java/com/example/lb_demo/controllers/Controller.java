package com.example.lb_demo.controllers;

import com.example.lb_demo.domain.Person;
import com.example.lb_demo.repostirories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class Controller {

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("person")
    public String createPerson(@RequestParam String name) {
        personRepository.save(new Person(name, "70"));
        return personRepository.findByName(name) + " saved successfully!";
    }

    @GetMapping("person")
    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }

    @DeleteMapping("person")
    public void deletePerson(@RequestParam Long id) {
        personRepository.deleteById(id);
    }
}
