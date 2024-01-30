package com.malise.app.service.product.commandhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malise.app.model.product.Product;
import com.malise.app.repository.product.ProductRepository;
import com.malise.app.service.product.Command;

import io.micrometer.common.util.StringUtils;

@Service
public class CreateProductCommandHandler implements Command<Product, ResponseEntity> {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ResponseEntity execute(Product product) {

    validateProduct(product);

    productRepository.save(product);

    return ResponseEntity.ok().build();
  }

  private void validateProduct(Product product) {
    // name
    if (StringUtils.isBlank(product.getName())) {
      throw new RuntimeException("Product name cannot be Empty");
    }
    // description
    if (StringUtils.isBlank(product.getDescription())) {
      throw new RuntimeException("Description cannot be Empty");
    }
    // price
    if (product.getPrice() <= 0.0) {
      throw new RuntimeException("Price cannot be less than zero");
    }
    // quantity
    if (product.getQuantity() <= 0) {
      throw new RuntimeException("Quantity cannot be less than zero");
    }
  }

}
