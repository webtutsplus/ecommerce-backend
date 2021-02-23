package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.AddToCartDto;
import com.webtutsplus.ecommerce.dto.CartDto;
import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.exceptions.AuthenticationFailException;
import com.webtutsplus.ecommerce.exceptions.ProductNotExistException;
import com.webtutsplus.ecommerce.model.*;
import com.webtutsplus.ecommerce.service.AuthenticationService;
import com.webtutsplus.ecommerce.service.CartService;
import com.webtutsplus.ecommerce.service.ProductService;
import com.webtutsplus.ecommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
        authenticationService.authenticate(token);

        int userId = authenticationService.getUser(token).getId();

        cartService.addToCart(addToCartDto,userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartCost> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        int user_id = authenticationService.getUser(token).getId();
        CartCost cartCost = cartService.listCartItems(user_id);
        return new ResponseEntity<CartCost>(cartCost,HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@PathVariable("cartItemId") int itemID, @RequestBody @Valid CartDto cartDto,
                                                      @RequestParam("token") String token,@RequestParam("quantity") int quantity) throws AuthenticationFailException,ProductNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();

        Product product = productService.getProductById(cartDto.getProductId());

        cartService.updateCartItem(itemID, cartDto,product,userId,quantity);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException{
        authenticationService.authenticate(token);

        int userId = authenticationService.getUser(token).getId();

        cartService.deleteCartItem(itemID,userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

}
