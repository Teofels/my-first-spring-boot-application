package com.example.myfirstspringbootapplication.service;

import java.util.List;

import com.example.myfirstspringbootapplication.dto.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerService extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
