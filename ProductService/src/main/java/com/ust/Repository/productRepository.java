package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.model.Product;

public interface productRepository extends JpaRepository<Product, String> {

	Product getByProductId(int productId);
}
