package com.webtutsplus.ecommerce.service;

import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Used to get the list of all products but in the form of a Product Data
     * Transfer Object rather than just the normal Product Object.
     * @return A list of ProductDto's.
     */
    public List<ProductDto> listProducts() {
        // Get a list of all current products in the database.
        List<Product> products = productRepository.findAll();
        // Create an empty list of productDto's.
        List<ProductDto> productDtos = new ArrayList<>();

        // Loop over all the products and map them to a productDto
        // and add them to the list of productDtos.
        for(Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }

        return productDtos;
    }

    /**
     * Used to add product's to the database.
     * @param productDto The productDto which we got from the front-end.
     * @param category The category that we inferred from the category ID
     *                 which we got from the front-end.
     */
    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    /**
     * Used to update an existing product.
     * @param productID The product's ID, which we want to update.
     * @param productDto The productDto, which we got from the front-end.
     * @param category The category that we inferred from the category ID,
     *                  which we got from the front-end.
     */
    public void updateProduct(long productID, ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        product.setId(productID);
        productRepository.save(product);
    }

    /**
     * Used as a utility function inside this class, to create a productDto
     * from a product object. (The function is made private because it isn't
     * used outside this class.)
     * @param product The product object which we wish to convert.
     * @return A productDto object.
     */
    private static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    /**
     * Used as a utility function inside this class, to create a product from
     * a productDto object. (This function is made private because it isn't
     * used outside of this class.)
     * @param productDto The productDto object which we want to convert.
     * @param category The category to which the product should belong to.
     * @return A product object.
     */
    private static Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product(productDto, category);
        return product;
    }
}
