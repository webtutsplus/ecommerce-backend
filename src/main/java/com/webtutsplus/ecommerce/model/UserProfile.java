package com.webtutsplus.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String email;
	private String firstName;
	private String lastName;

	/**
	 * Default constructor for the UserProfile object.
	 */
	public UserProfile() {}

	/**
	 * Constructor for the UserProfile object.
	 * @param id The ID of the profile.
	 * @param username The username of the profile.
	 * @param email The email address of the profile.
	 * @param firstName The first name of the profile.
	 * @param lastName The last name of the profile.
	 */
	public UserProfile(long id, String username, String email, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Used to get the ID of the profile.
	 * @return The ID of type Long.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Used to set the ID of the profile.
	 * @param id The new profile ID.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Used to get the username of the profile.
	 * @return The username of type String.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Used to set the username of the profile.
	 * @param username The new profile username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Used to get the email address of the profile.
	 * @return The email address of type String.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Used to set the email address of the profile.
	 * @param email The new profile email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Used to get the first name of the profile.
	 * @return The first name of type String.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Used to set the first name of the profile.
	 * @param firstName The new first name for the profile.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Used to get the last name of the profile.
	 * @return The last name of type String.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Used to set the last name of the profile.
	 * @param lastName The new last name of the profile.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
