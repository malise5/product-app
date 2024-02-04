package com.malise.app.controller.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malise.app.repository.address.AddressRepository;

@RestController
@RequestMapping("/address")
public class AddressController {

  @Autowired
  private AddressRepository addressRepository;

}
