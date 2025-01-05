package com.example.Exitapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * this class is used to create product entity
 * @author vishakhachaudhary
 *
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productname;
	private String productcode;
	private String productbrand;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> review;

	
	public Product() {
		super();
	}
	/**
	 * @param productId
	 * @param productname
	 * @param productcode
	 * @param productbrand
	 * @param review
	 */
	public Product(int productId, String productname, String productcode, String productbrand, List<Review> review) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productcode = productcode;
		this.productbrand = productbrand;
		this.review = review;
	}


	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}


	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}


	/**
	 * @param productname the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}


	/**
	 * @return the productcode
	 */
	public String getProductcode() {
		return productcode;
	}


	/**
	 * @param productcode the productcode to set
	 */
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}


	/**
	 * @return the productbrand
	 */
	public String getProductbrand() {
		return productbrand;
	}


	/**
	 * @param productbrand the productbrand to set
	 */
	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}


	/**
	 * @return the review
	 */
	public List<Review> getReview() {
		return review;
	}


	/**
	 * @param review the review to set
	 */
	public void setReview(List<Review> review) {
		this.review = review;
	}
	
	/**
	 * this function is used to get the average rating for the product only for approved reviews
	 * @return
	 */
	
	public double getAverageRating() {
		if(review.isEmpty()) {
			return 0.0;
		}
		double avg = 0.0;
		int size = 0;
		for(Review reviews : review) {
			if("approved".equals(reviews.getState())) {
				avg = avg + reviews.getRating();
				size = size +1;
			}
		}
		double avgrating = avg/size;
		return Math.round(avgrating * 10.0)/10.0;
			
		}
			
		
	

}
