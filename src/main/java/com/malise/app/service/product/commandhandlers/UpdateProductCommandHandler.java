package com.malise.app.service.product.commandhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malise.app.model.product.Product;
import com.malise.app.model.product.UpdateProductCommand;
import com.malise.app.repository.product.ProductRepository;
import com.malise.app.service.product.Command;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand, ResponseEntity> {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ResponseEntity<ResponseEntity> execute(UpdateProductCommand command) {

    Product product = command.getProduct();

    product.setId(command.getId());

    productRepository.save(product);
    return ResponseEntity.ok().build();
  }

}
