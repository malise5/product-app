package com.malise.app.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malise.app.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
