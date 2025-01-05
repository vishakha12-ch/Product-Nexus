package com.example.Exitapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * this class is used to create review entity
 * @author vishakhachaudhary
 *
 */

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private String review;
	private float rating;
	private String state;
	private String username;
	
	@ManyToOne
	@JsonIgnoreProperties("review")
	private Product product;

	
	
	/**
	 * 
	 */
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param reviewId
	 * @param review
	 * @param rating
	 * @param state
	 * @param username
	 * @param product
	 */
	public Review(int reviewId, String review, float rating, String state, String username, Product product) {
		super();
		this.reviewId = reviewId;
		this.review = review;
		this.rating = rating;
		this.state = state;
		this.username = username;
		this.product = product;
	}

	/**
	 * @return the reviewId
	 */
	public int getReviewId() {
		return reviewId;
	}

	/**
	 * @param reviewId the reviewId to set
	 */
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	

}
