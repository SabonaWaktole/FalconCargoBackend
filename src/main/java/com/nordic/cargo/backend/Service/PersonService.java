package com.nordic.cargo.backend.Service;

import com.nordic.cargo.backend.Model.PersonModel;
import com.nordic.cargo.backend.Repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    private boolean existsByEmail(String email) {
        return personRepository.findByEmail(email).isPresent();
    }

    //==== Update, add delete Functions ====//
    public ResponseEntity<?> addNewCustomer(PersonModel customer) {
        try {
            // Check if customer already exists
            return personRepository.findByEmail(customer.getEmail())
                    .map(ResponseEntity::ok) // Return existing
                    .orElseGet(() -> {
                        // Save new customer
                        PersonModel savedPerson = personRepository.save(customer);
                        return ResponseEntity.ok(savedPerson);
                    });
        } catch (Exception e) {
            // Handle unexpected errors
//            System.out.println("exception occured her \n sabona");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    public ResponseEntity<?> removeCustomer(String email) {
        return personRepository.findByEmail(email)
                .map(person -> {
                    personRepository.delete(person);
                    return ResponseEntity.ok("Person deleted successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> increaseServiceCount(String email) {
        return personRepository.findByEmail(email)
                .map(person -> {
                    person.setServiceCount(person.getServiceCount() + 1);
                    personRepository.save(person);
                    return ResponseEntity.ok("Service count increased to " + person.getServiceCount());
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Customer not found"));
    }



    //==== Retrieval Functions ====//

    public ResponseEntity<?> getCustomerByEmail(String email) {
        return personRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    public ResponseEntity<?> updateCustomerInfo(String email, PersonModel updatedInfo) {
        return personRepository.findByEmail(email)
                .map(existing -> {
                    // Update allowed fields
                    existing.setFirstName(updatedInfo.getFirstName());
                    existing.setMiddleName(updatedInfo.getMiddleName());
                    existing.setLastName(updatedInfo.getLastName());
                    existing.setPrimaryAddress(updatedInfo.getPrimaryAddress());
                    existing.setSecondaryAddress(updatedInfo.getSecondaryAddress());
                    existing.setCity(updatedInfo.getCity());
                    existing.setState(updatedInfo.getState());
                    existing.setCountry(updatedInfo.getCountry());
                    existing.setZipCode(updatedInfo.getZipCode());
                    existing.setPhoneNumber(updatedInfo.getPhoneNumber());
                    existing.setFaxNumber(updatedInfo.getFaxNumber());
                    existing.setLanguages(updatedInfo.getLanguages());
                    existing.setVat(updatedInfo.getVat());
                    // Don’t update serviceCount here unless that’s intentional

                    personRepository.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
