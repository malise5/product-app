package com.malise.app.model.product;

import lombok.Data;

@Data
public class ProductDTO {

  private String name;
  private String description;
  private Double price;
  private int quantity;

  public ProductDTO(Product product) {
    this.name = product.getName();
    this.description = product.getDescription();
    this.price = product.getPrice();
    this.quantity = product.getQuantity();
  }

}
