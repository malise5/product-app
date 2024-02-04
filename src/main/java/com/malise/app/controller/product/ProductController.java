package com.malise.app.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malise.app.model.product.Product;
import com.malise.app.model.product.ProductDTO;
import com.malise.app.model.product.UpdateProductCommand;
import com.malise.app.repository.product.ProductRepository;
import com.malise.app.service.product.commandhandlers.CreateProductCommandHandler;
import com.malise.app.service.product.commandhandlers.DeleteProductCommandHandler;
import com.malise.app.service.product.commandhandlers.UpdateProductCommandHandler;
import com.malise.app.service.product.queryhandlers.GetAllProductsQueryHandler;
import com.malise.app.service.product.queryhandlers.GetProductQueryHandler;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private GetAllProductsQueryHandler getAllProductsQueryHandler;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getProducts() {
    return getAllProductsQueryHandler.execute(null);
  }

  @Autowired
  private GetProductQueryHandler getProductQueryHandler;

  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
    return getProductQueryHandler.execute(id);
  }

  @Autowired
  private CreateProductCommandHandler createProductCommandHandler;

  @PostMapping
  public ResponseEntity createProduct(@RequestBody Product product) {
    return createProductCommandHandler.execute(product);
  }

  @Autowired
  private UpdateProductCommandHandler updateProductCommandHandler;

  @PutMapping("/{id}")
  public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {

    UpdateProductCommand command = new UpdateProductCommand(id, product);

    return updateProductCommandHandler.execute(command);

  }

  @Autowired
  private DeleteProductCommandHandler deleteProductCommandHandler;

  @DeleteMapping("/{id}")
  public ResponseEntity deleteProduct(@PathVariable Integer id) {
    return deleteProductCommandHandler.execute(id);
  }

}
