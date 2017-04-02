package com.example.services;

import com.example.data.Person;
import com.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public void save(Person person){
        repository.save(person);
    }

    public List<Person> findAll(){
        return repository.findAll();
    }
    public Optional<Person> findOne(long id){
        return Optional.ofNullable(repository.findOne(id));
    }
}
