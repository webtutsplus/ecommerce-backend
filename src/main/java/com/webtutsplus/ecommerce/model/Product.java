package com.webtutsplus.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webtutsplus.ecommerce.dto.ProductDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    /**
     * Constructor for the Product object.
     * @param productDto The Product Data Transfer Object.
     * @param category The category to which the object belongs.
     */
    public Product(ProductDto productDto, Category category) {
        this.name = productDto.getName();
        this.imageURL = productDto.getImageURL();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.category = category;
    }

    /**
     * Constructor for the Product object.
     * @param name The name of the product.
     * @param imageURL The image URL for the product.
     * @param price The price of the product.
     * @param description The description of the product.
     * @param category The category to which this product belongs.
     */
    public Product(String name, String imageURL, double price, String description, Category category) {
        super();
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    /**
     * Default constructor for the Product object.
     */
    public Product() {
    }

    /**
     * Used to get the ID of the product.
     * @return Product ID of type Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Used to set the ID of the object.
     * @param id The new ID of the object.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Used to get the name of the product.
     * @return Product name of type String.
     */
    public String getName() {
        return name;
    }

    /**
     * Used to set the name of the object.
     * @param name The new name of the object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Used to get the image URL of the product.
     * @return Product image URL of type String.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Used to set the image URL of the object.
     * @param imageURL The new image URL of the object.
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Used to get the price of the product.
     * @return Product price of type Double.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Used to set the price of the object.
     * @param price The new price of the object.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Used to get the description of the product.
     * @return Product description of type String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Used to set the description of the object.
     * @param description The new description of the object.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Used to get the category to which the product belongs.
     * @return Product category of type Category.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Used to set the category of the object.
     * @param category The new category of the object.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Used to generate a String containing information about the object.
     * @return A String of information about the object.
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
