package com.example.Exitapi.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Exitapi.entity.Product;
import com.example.Exitapi.entity.Review;

/**
 * Review repository extend jparepository that help to perform crud opeartion on review entity
 * @author vishakhachaudhary
 *
 */
public interface ReviewRepo extends JpaRepository<Review, Integer> {
	public Review findByReviewId(int reviewId);
	
	

}
