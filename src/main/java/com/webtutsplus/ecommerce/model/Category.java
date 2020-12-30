package com.webtutsplus.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "category_name")
	private @NotBlank String categoryName;

	private @NotBlank String description;
	private @NotBlank String imageUrl;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	Set<Product> products;
	
	public Category() {}

	/**
	 * Constructor for the Category object.
	 * @param categoryName The name of the category.
	 * @param description A description of the category.
	 */
	public Category(@NotBlank String categoryName, @NotBlank String description) {
		this.categoryName = categoryName;
		this.description = description;
	}

	/**
	 * Constructor for the Category object.
	 * @param categoryName The name of the category.
	 * @param description A description of the category.
	 * @param imageUrl An image to describe the category.
	 */
	public Category(@NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl) {
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	/**
	 * Used to get the name of the category.
	 * @return category name of type String.
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Used to set the name of the category.
	 * @param categoryName the new name of the category.
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Used to get the description of the category.
	 * @return category description of type String.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Used to set the description of the category.
	 * @param description the new description of the category.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Used to get the set of all products that are apart of the category.
	 * @return set of products.
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * Used to set the set of products in the category.
	 * @param products the new set of products in the category.
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/**
	 * Used to create a string containing information about the object.
	 * @return a string made up of information about the object.
	 */
	@Override
	public String toString() {
		return "User {category id=" + id + ", category name='" + categoryName + "', description='" + description + "'}";
	}

	/**
	 * Used to get the image URL of the category.
	 * @return image URL of type String.
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Used to set the description of the category.
	 * @param imageUrl the new description of the category.
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Used to get the ID of the category.
	 * @return category ID of type Long.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Used to set the ID of the category.
	 * @param id the new ID of the category.
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
