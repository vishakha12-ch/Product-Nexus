package com.example.Exitapi.dto;

public class UserDTO {
	
	private int id;
	private String username;
	private String role;
	private String email;
	/**
	 * 
	 */
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param username
	 * @param role
	 * @param email
	 */
	public UserDTO(int id, String username, String role, String email) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.email = email;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
