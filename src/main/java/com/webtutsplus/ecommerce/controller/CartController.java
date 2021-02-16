package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.CartDto;
import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.model.Cart;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.model.WishList;
import com.webtutsplus.ecommerce.service.AuthenticationService;
import com.webtutsplus.ecommerce.service.CartService;
import com.webtutsplus.ecommerce.service.ProductService;
import com.webtutsplus.ecommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<ApiResponse> addToCart(@RequestBody CartDto cartDto, @RequestParam("token") String token) {
        int userId = authenticationService.getUser(token).getId();
        System.out.println("DTO : " + cartDto.toString());
        Optional<Product> optionalProduct = productService.readProduct(cartDto.getProductId());
        System.out.println("Product" + optionalProduct.toString());
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Item is invalid"), HttpStatus.CONFLICT);
        }
        Product product = optionalProduct.get();
        cartService.addToCart(cartDto,product,userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<List<CartDto>> getCartItems() {
        List<CartDto> body = cartService.listCartItems();
        return new ResponseEntity<List<CartDto>>(body,HttpStatus.OK);

    }
    @PostMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@PathVariable("cartItemId") long itemID, @RequestBody @Valid CartDto cartDto) {
        Optional<Product> optionalProduct = productService.readProduct(cartDto.getProductId());
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "product is invalid"), HttpStatus.CONFLICT);
        }
        Product product = optionalProduct.get();
        cartService.updateCartItem(itemID, cartDto, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID){
        System.out.println("ITEM ID : " + itemID);
        cartService.deleteCartItem(itemID);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Item has been removed"),HttpStatus.OK);
    }


}
