package com.example.Exitapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exitapi.entity.Product;
import com.example.Exitapi.entity.Review;
import com.example.Exitapi.repository.ReviewRepo;
/**
 * this class is used to store,retrieve reviews
 * @author vishakhachaudhary
 *
 */
@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepo repo;
	
	@Autowired
	private ProductService service;
	
	/**
	 * this method add reviews
	 * @param review
	 * @param id
	 * @return
	 */
	public Review postreviews(Review review, int id) {
		Product product = service.getproductId(id);
		product.getReview().add(review);
		service.addproduct(product);
		review.setProduct(product);
		repo.save(review);
		return review;		
	}
	/**
	 * this method to get all reviews
	 * @return
	 */
	
	public List<Review> allreview(){
		List<Review> reviews= repo.findAll();
		return reviews;
	}
	/**
	 * this method is used to approve specified review
	 * @param id
	 * @param state
	 * @return
	 */
	
	public Review approves(int id, String state){
		Review review = repo.findByReviewId(id);
		review.setState(state);
		repo.save(review);
		return  review;
		
	}
	
	
}
