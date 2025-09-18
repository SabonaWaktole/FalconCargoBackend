package com.nordic.cargo.backend.Service;

import com.nordic.cargo.backend.Model.PersonModel;
import com.nordic.cargo.backend.Repositories.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean existsByEmail(String email) {
        return personRepository.findByEmail(email).isPresent();
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

    public ResponseEntity<?> removeCustomer(String email) {
        return personRepository.findByEmail(email)
                .map(person -> {
                    personRepository.delete(person);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public boolean increaseServiceCount(String email) {
        return personRepository.findByEmail(email).map(person -> {
            person.setServiceCount(person.getServiceCount() + 1);
            personRepository.save(person);
            return true;
        }).orElse(false);
    }

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
