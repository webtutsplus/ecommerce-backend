package com.webtutsplus.ecommerce.controller;

import com.webtutsplus.ecommerce.model.UserWishList;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserWishListController {

        private List<UserWishList> wishLists = new ArrayList<>();

        public UserWishListController() {
        }

        @PostMapping(path = "/wishlist")
        public void addWishList(@RequestBody UserWishList userWishList){
            wishLists.add(userWishList);
        }

        @GetMapping(path = "/wishlist/{userId}")
        public UserWishList getWishList(@PathVariable int userId){
                return wishLists.get(userId - 1);
        }
}
