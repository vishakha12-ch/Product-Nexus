package com.example.Exitapi.controller;

import java.util.List;

import javax.swing.text.html.FormView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exitapi.entity.Askreview;
import com.example.Exitapi.entity.Product;
import com.example.Exitapi.entity.Review;
import com.example.Exitapi.repository.AskreviewRepo;
import com.example.Exitapi.service.ProductService;
import com.example.Exitapi.service.ReviewService;

/**
 * This controller class implement api for reviews
 * @author vishakhachaudhary
 *
 */

@RestController
@CrossOrigin
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private AskreviewRepo repo;
	
	/**
	 * This api is used to add review to database with specified product id
	 * @param review
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	@PostMapping("/postreview/{id}")
	public ResponseEntity postreview(@RequestBody Review review ,@PathVariable("id") int id )throws Exception {
		try {
			 Review reviews=service.postreviews(review, id);
			 return ResponseEntity.ok(reviews);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This api return all reviews
	 * @return
	 * @throws Exception
	 */
	
	
	@GetMapping("getreview")
	public ResponseEntity getallreview() throws Exception{
		try {
			List<Review> list = service.allreview();
			return ResponseEntity.ok(list);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * this api approve review for specified id and with state
	 * @param id
	 * @param state
	 * @return
	 * @throws Exception
	 */
	
	@GetMapping("/approve/{id}/{state}")
	public ResponseEntity approve(@PathVariable("id") int id, @PathVariable("state") String state) throws Exception{
		try {
			Review list = service.approves(id, state);
			return ResponseEntity.ok(list);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	/**
	 * this api is used to store askreview info in databasse
	 * @param askreview
	 * @return
	 */
	
	@PostMapping("Askreview")
	public ResponseEntity askreview(@RequestBody Askreview askreview) {
		Askreview data = repo.save(askreview);
		return ResponseEntity.ok(data);
		
	}
	
	
}
