package com.webtutsplus.ecommerce.service;

import com.webtutsplus.ecommerce.dto.CartDto;
import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.model.Cart;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.model.WishList;
import com.webtutsplus.ecommerce.repository.CartRepository;
import com.webtutsplus.ecommerce.repository.WishListRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


//    public static ProductDto getDtoFromProduct(Product product) {
//        ProductDto productDto = new ProductDto(product);
//        return productDto;
//    }

    public static Cart getCartFromDto(CartDto cartDto, Product product,int userId) {
        Cart cart = new Cart(cartDto, product,userId);
        return cart;
    }

    public void addToCart(CartDto cartDto, Product product,int userId) {
        Cart cart = getCartFromDto(cartDto, product,userId);
        cartRepository.save(cart);
    }


}


