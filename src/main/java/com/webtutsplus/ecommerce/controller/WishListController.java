package com.webtutsplus.ecommerce.controller;


import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.model.WishList;
import com.webtutsplus.ecommerce.service.ProductService;
import com.webtutsplus.ecommerce.service.WishListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

        @Autowired
        private WishListService wishListService;

        @GetMapping("/{user_id}")
        public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("user_id") Integer user_id) {
                List<WishList> body = wishListService.readWishList(user_id);
                List<ProductDto> products = new ArrayList<ProductDto>();
                for (WishList wishList : body) {
                        products.add(ProductService.getDtoFromProduct(wishList.getProduct()));
                }

                return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<ApiResponse> addWishList(@Valid @RequestBody WishList wishList) {
                wishListService.createWishlist(wishList);
                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);
        }


}
