package com.example.myfirstspringbootapplication.http;

import com.example.myfirstspringbootapplication.dto.Customer;
import com.example.myfirstspringbootapplication.exceptions.CustomerNotFoundException;
import com.example.myfirstspringbootapplication.service.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository repository;

    /**
     * пример BODY для отправки: {"firstName": "testFirstName", "lastName": "testLastName"}
     */
    @PostMapping(path = "/customer/registration")
    public Customer register(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
