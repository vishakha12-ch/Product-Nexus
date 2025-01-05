package com.example.Exitapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Exitapi.entity.Product;

/**
 * Product repository extend jparepository that help to perform crud opeartion on product entity
 * @author vishakhachaudhary
 *
 */
public interface ProductRepo extends JpaRepository<Product, Integer> {
	public List<Product> findByProductnameOrProductbrand(String productname,String productbrand);
	public Product findByProductId(int productId);
	

}

