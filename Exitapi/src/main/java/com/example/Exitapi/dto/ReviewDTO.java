package com.example.Exitapi.dto;

import com.example.Exitapi.entity.Product;

public class ReviewDTO {
	
	private String review;
	private float rating;
	private String state;
	private String username;
	private Product product;
	/**
	 * 
	 */
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param review
	 * @param rating
	 * @param state
	 * @param username
	 * @param product
	 */
	public ReviewDTO(String review, float rating, String state, String username, Product product) {
		super();
		this.review = review;
		this.rating = rating;
		this.state = state;
		this.username = username;
		this.product = product;
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
