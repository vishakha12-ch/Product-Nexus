package com.example.Exitapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exitapi.entity.Product;
import com.example.Exitapi.service.ProductService;

/**
 * This controller class implement product api
 * @author vishakhachaudhary
 *
 */

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService service; 
	
	/**
	 * This api is used to fetch product by search
	 * @param search 
	 * @return
	 */
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getproduct/{search}")
	public ResponseEntity<?> searchproduct(@PathVariable("search") String search){
		search = search.replaceAll(" ","");
		List<Product> product= service.searchproduct(search) ;
		if(product.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found");
		}
		else {
			return ResponseEntity.ok(product);
		}
	}
	
	/**
	 * This api is used to fetch product by Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	@GetMapping("/productbyId/{id}")
	public Product productbyId(@PathVariable("id") int id)throws Exception {
		try {
			return this.service.getproductId(id);
		}catch(Exception e) {
			throw new Exception("No Product Found");
		}
		
	}
	
	/**
	 * This API used to fetch the average rating of project only for approved reviews
	 * @param id
	 * @return
	 */
	
	@GetMapping("/average/{id}")
	public ResponseEntity<?> getAverageRating(@PathVariable("id") int id){
			double averageRating =  service.getAverageRating(id);
			return ResponseEntity.ok(averageRating);
}
	
}
