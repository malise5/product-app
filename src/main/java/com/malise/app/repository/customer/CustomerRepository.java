package com.malise.app.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malise.app.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
