package com.nordic.cargo.backend.Service;

import com.nordic.cargo.backend.Model.PersonModel;
import com.nordic.cargo.backend.Repositories.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.TableView;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity<?> addNewCustomer(PersonModel customer){
        try {
            personRepository.save(customer);
            // TODO Return jwt responses here
            return  ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<?> removeCustomer(PersonModel customer){
        try {
            personRepository.delete(customer);
            return   ResponseEntity.ok().build();
        }catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public boolean increaseServiceCount(String email) {
        return personRepository.findByEmail(email).map(person -> {
            person.setServiceCount(person.getServiceCount() + 1);
            personRepository.save(person);
            return true;
        }).orElse(false);
    }

}
