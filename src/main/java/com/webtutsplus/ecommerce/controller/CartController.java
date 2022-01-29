package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.cart.AddToCartDto;
import com.webtutsplus.ecommerce.dto.cart.CartDto;
import com.webtutsplus.ecommerce.exceptions.AuthenticationFailException;
import com.webtutsplus.ecommerce.exceptions.CartItemNotExistException;
import com.webtutsplus.ecommerce.exceptions.ProductNotExistException;
import com.webtutsplus.ecommerce.model.*;
import com.webtutsplus.ecommerce.service.AuthenticationService;
import com.webtutsplus.ecommerce.service.CartService;
import com.webtutsplus.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        Product product = productService.getProductById(addToCartDto.getProductId());
        System.out.println("product to add"+  product.getName());
        cartService.addToCart(addToCartDto, product, user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid AddToCartDto cartDto,
                                                      @RequestParam("token") String token) throws AuthenticationFailException,ProductNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        Product product = productService.getProductById(cartDto.getProductId());
        cartService.updateCartItem(cartDto, user,product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();
        cartService.deleteCartItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

}
