package com.malise.app.service.product.commandhandlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malise.app.Exceptions.ProductNotFoundException;
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

    Optional<Product> optionalProduct = productRepository.findById(command.getId());

    if (optionalProduct.isEmpty()) {
      throw new ProductNotFoundException();
    }

    Product product = command.getProduct();

    product.setId(command.getId());

    productRepository.save(product);
    return ResponseEntity.ok().build();
  }

}
