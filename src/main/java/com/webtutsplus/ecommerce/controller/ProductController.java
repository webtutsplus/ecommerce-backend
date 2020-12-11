package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> body = productService.listProducts();
        return new ResponseEntity<List<Product>>(body, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid Product product) {
        productService.addProduct(product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    @PostMapping("/update/{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") long productID, @RequestBody @Valid Product product) {
        productService.updateProduct(productID, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }
}
