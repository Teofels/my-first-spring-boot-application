package com.example.myfirstspringbootapplication.http;

import com.example.myfirstspringbootapplication.dto.Customer;
import com.example.myfirstspringbootapplication.service.CustomerRepository;
import com.example.myfirstspringbootapplication.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository repository;


    /**
     * пример BODY для отправки: {"firstName": "testFirstName", "lastName": "testLastName"}
     */
    @PostMapping(path = "/customer/registration")
    public Customer getUser(@RequestBody Customer customer) {
        return repository.save(customer);
    }

}
