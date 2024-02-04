package com.malise.app.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malise.app.model.address.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
