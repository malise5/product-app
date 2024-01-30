package com.malise.app.service.product.queryhandlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malise.app.model.product.ProductDTO;
import com.malise.app.repository.product.ProductRepository;
import com.malise.app.service.product.Query;

@Service
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDTO>> {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ResponseEntity<List<ProductDTO>> execute(Void input) {

    List<ProductDTO> productDTOs = productRepository.findAll().stream().map(ProductDTO::new).toList();
    return ResponseEntity.ok(productDTOs);

  }

}
