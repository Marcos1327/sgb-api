package com.marcos.sigeb.controller;

import com.marcos.sigeb.entity.dto.CustomerDTO;
import com.marcos.sigeb.entity.model.Customer;
import com.marcos.sigeb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/find-customer-by-id/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @DeleteMapping("/delete-customer-by-id/{customerId}")
    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
