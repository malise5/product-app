package com.malise.app.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malise.app.model.customer.Customer;
import com.malise.app.repository.customer.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping
  public ResponseEntity<List<Customer>> getCustomer() {
    return ResponseEntity.ok(customerRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
    return ResponseEntity.ok(customerRepository.findById(id).get());
  }

  @PostMapping
  public ResponseEntity updateCustomer(@RequestBody Customer customer) {
    customerRepository.save(customer);
    return ResponseEntity.ok().build();
  }

}
