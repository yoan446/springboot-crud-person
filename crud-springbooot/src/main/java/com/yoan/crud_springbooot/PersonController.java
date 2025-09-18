package com.yoan.crud_springbooot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("api/persons")
public class PersonController {
    
    final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

   @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person personCreated = personRepository.save(person);
        return new ResponseEntity<>(personCreated,HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional <Person>  person =  personRepository.findById(id);

        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(person.get(), HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long  id, @RequestBody Person personDetails) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            Person existingPerson = person.get();
            existingPerson.setCity(personDetails.getCity());
            existingPerson.setPhonenumber(personDetails.getPhonenumber());

            Person updatePerson = personRepository.save(existingPerson);
            return new ResponseEntity<>(updatePerson, HttpStatus.OK);
        }
         return new ResponseEntity<>(person.get(), HttpStatus.NOT_FOUND);
         
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson (@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);
        
        if(person.isPresent()){
            personRepository.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
         
    }

    
}
