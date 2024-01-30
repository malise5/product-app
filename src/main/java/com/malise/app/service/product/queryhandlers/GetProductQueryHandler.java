package com.malise.app.service.product.queryhandlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malise.app.model.product.Product;
import com.malise.app.model.product.ProductDTO;
import com.malise.app.repository.product.ProductRepository;
import com.malise.app.service.product.Query;

@Service
public class GetProductQueryHandler implements Query<Integer, ProductDTO> {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ResponseEntity<ProductDTO> execute(Integer id) {
    Optional<Product> product = productRepository.findById(id);
    if (product.isEmpty()) {
      // Throw an exception
      throw new RuntimeException("Product not found");
    }
    return ResponseEntity.ok(new ProductDTO(product.get()));

  }

}
