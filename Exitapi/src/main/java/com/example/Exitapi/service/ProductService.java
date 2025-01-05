package com.example.Exitapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exitapi.entity.Product;
import com.example.Exitapi.repository.ProductRepo;

/**
 * this class is used to store,retrieve product details
 * @author vishakhachaudhary
 *
 */
@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	/**
	 * this method search product by name or brand
	 * @param search
	 * @return
	 */
	public List<Product> searchproduct(String search){
		return repo.findByProductnameOrProductbrand(search, search);
	}
	
	/**
	 * this method is to get product by id
	 * @param id
	 * @return
	 */
	public Product getproductId(int id) { 
		return repo.findByProductId(id)	;
	}
	
	/**
	 * this method is used to add product
	 * @param product
	 * @return
	 */
	public Product addproduct(Product product)
	{
		Product productId=repo.findByProductId(product.getProductId());
		System.out.println(productId);
		if(productId!=null)
		{
			return null;
		}
		return repo.save(product);
	}
	
	/**
	 * to get average rating of product
	 * @param id
	 * @return
	 */
	
	public double getAverageRating(int id) {
		Product product = repo.findByProductId(id);
		return product.getAverageRating();
	}

}
