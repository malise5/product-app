package com.malise.app.service.product.commandhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malise.app.model.product.Product;
import com.malise.app.repository.product.ProductRepository;
import com.malise.app.service.product.Command;

@Service
public class DeleteProductCommandHandler implements Command<Integer, ResponseEntity> {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ResponseEntity<ResponseEntity> execute(Integer id) {

    Product product = productRepository.findById(id).get();
    productRepository.delete(product);
    return ResponseEntity.ok().build();
  }

}
