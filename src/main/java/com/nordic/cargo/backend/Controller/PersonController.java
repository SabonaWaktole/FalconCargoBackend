package com.nordic.cargo.backend.Controller;


import com.nordic.cargo.backend.Model.PersonModel;
import com.nordic.cargo.backend.Service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    private final PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewCustomer(@RequestBody PersonModel customer){
        return personService.addNewCustomer(customer);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeCustomer(@RequestBody String email){
        return personService.removeCustomer(email);
    }

    @PutMapping("/increase")
    public ResponseEntity<?> increaseServiceCount(@RequestBody String email){
        return personService.increaseServiceCount(email);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable String email){
        return  personService.getCustomerByEmail(email);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomers(){
        return personService.getAllCustomers();
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateCustomer(@PathVariable String email, @RequestBody PersonModel customer){
        return personService.updateCustomerInfo(email, customer);
    }


}
