package com.webtutsplus.ecommerce.controller;


import com.webtutsplus.ecommerce.common.ApiResponse;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.model.WishList;
import com.webtutsplus.ecommerce.service.WishListService;
import com.webtutsplus.ecommerce.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
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
        public ResponseEntity<List<WishList>> getWishList(@PathVariable("user_id") Integer user_id) {
                List<WishList> body = wishListService.readWishList(user_id);
                return new ResponseEntity<List<WishList>>(body, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<ApiResponse> addWishList(@Valid @RequestBody WishList wishList) {
                wishListService.createWishlist(wishList);
                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);
        }


}
