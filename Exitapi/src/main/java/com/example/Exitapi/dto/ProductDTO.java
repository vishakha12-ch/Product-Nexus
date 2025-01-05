package com.example.Exitapi.dto;

public class ProductDTO {
	
	private String productname;
	private String productcode;
	private String productbrand;
	/**
	 * 
	 */
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param productname
	 * @param productcode
	 * @param productbrand
	 */
	public ProductDTO(String productname, String productcode, String productbrand) {
		super();
		this.productname = productname;
		this.productcode = productcode;
		this.productbrand = productbrand;
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
	
	

}
