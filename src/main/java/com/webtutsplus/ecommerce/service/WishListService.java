package com.webtutsplus.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.webtutsplus.ecommerce.model.WishList;
import com.webtutsplus.ecommerce.repository.WishListRepository;
import org.springframework.stereotype.Service;

import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.repository.Categoryrepository;

@Service
@Transactional
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<WishList> readWishList(Integer userId) {
        return wishListRepository.findAllByUserId(userId);
    }
}
