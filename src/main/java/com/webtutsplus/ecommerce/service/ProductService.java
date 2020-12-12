package com.webtutsplus.ecommerce.service;

import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(long productID, Product newProduct) {
        Product oldProduct = productRepository.findById(productID).get();
        oldProduct.setName(newProduct.getName());
        oldProduct.setImageURL(newProduct.getImageURL());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setDescription(newProduct.getDescription());

        productRepository.save(oldProduct);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}
