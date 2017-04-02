package com.example.controller;

import com.example.data.Person;
import com.example.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Person> people = service.findAll();
        if (!people.isEmpty())
            return ResponseEntity.ok(people);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        service.save(person);
        //if (person.getId() != 0) {
            return ResponseEntity.ok(person);
        //} else
           // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
