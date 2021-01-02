package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.service.CategoryService;
import com.webtutsplus.ecommerce.service.ProductService;
import com.webtutsplus.ecommerce.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private @Autowired ProductService productService;
    private @Autowired CategoryService categoryService;

    /**
     * Handles GET requests for /api/product/.
     * @return Returns a list of all current products.
     */
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
    }

    /**
     * Handles POST requests for /api/product/add. Its responsible for adding new products.
     * @param productDto It receives a ProductDTO (Product Data Transfer Object) object.
     * @return Returns a Response Entity containing an Api Response object.
     */
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        // Check to see if the product has a valid category.
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        // If the product doesn't have a valid category then send back an error message.
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }

        // If it does have a category present then add it to the products.
        Category category = optionalCategory.get();
        // The product model contains a reference to the category model so it is required to save the product to the database.
        productService.addProduct(productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    /**
     * Handles POST requests for /api/product/update/<productID>. This function is responsible for updating
     * the products currently saved in our database.
     * @param productID The ID of the product we want to update.
     * @param productDto A Product Data Transfer Object that we want to replace the previous product with.
     * @return Returns a Response Entity containing an Api Response object.
     */
    @PostMapping("/update/{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") long productID, @RequestBody @Valid ProductDto productDto) {
        // Get a reference to category in the object. It might return null so it must be checked before updating the
        // product.
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            // If the product does not contain a valid category send back an error.
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }

        // Send the productID, productDto and category to the update function that handles the interaction with the
        // database, and return a response of success.
        Category category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to /api/product/delete/{productID}. Used to delete the product.
     * @param productID The ID of the product you want to delete.
     * @return Returns a Response Entity containing an Api Response object.
     */
    @DeleteMapping("/delete/{productID}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productID") long productID) {
        productService.deleteProduct(productID);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been deleted"), HttpStatus.OK);
    }
}
