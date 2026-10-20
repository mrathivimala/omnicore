package com.data.management.omnicore.customer.controller;

import com.data.management.omnicore.customer.models.Customer;
import com.data.management.omnicore.customer.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://16.176.215.93")
public class CustomerDetailsController {
    @GetMapping("/")
    public String test() {

        return "Testing works";
    }

    private final CustomerRepository customerRepository;

    public CustomerDetailsController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> fetchCustomerList() {
        List<Customer> customerList =customerRepository.findAll();
        return ResponseEntity.ok(customerList);
    }
    @PostMapping("/save_customer")
    public ResponseEntity<Customer> saveCustomerDetails(@RequestBody Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }
}
