package com.webtutsplus.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ProductDto {
    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;

    @JsonProperty("category_id")
    private @NotNull Long categoryId;

    /**
     * Constructor for ProductDto.
     * @param name The product name.
     * @param imageURL The URL to the product image.
     * @param price The price of the product.
     * @param description The description of the product.
     * @param categoryId The ID of the category to which this product belongs.
     */
    public ProductDto(@NotNull String name, @NotNull String imageURL, @NotNull double price, @NotNull String description, @NotNull Long categoryId) {
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDto() {}

    /**
     * Used to get the name of the ProductDto object.
     * @return name of type String.
     */
    public String getName() {
        return name;
    }

    /**
     * Used to set the name of the ProductDto object.
     * @param name new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Used to get the URL for the image of the ProductDto object.
     * @return image URL of type String.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Used to set the image URL of the ProductDto object.
     * @param imageURL new image URL.
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Used to get the price of the ProductDto object.
     * @return price of type Double.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Used to set the price of the ProductDto object.
     * @param price new price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Used to get the description of the ProductDto object.
     * @return description of type String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Used to set the description of the ProductDto object.
     * @param description new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Used to get the category ID of the ProductDto object.
     * @return category ID of type Long.
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * Used to set the category ID of the ProductDto object.
     * @param categoryId new category ID.
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
