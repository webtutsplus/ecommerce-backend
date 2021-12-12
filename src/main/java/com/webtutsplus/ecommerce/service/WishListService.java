package com.webtutsplus.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import com.webtutsplus.ecommerce.dto.product.ProductDto;
import com.webtutsplus.ecommerce.model.User;
import com.webtutsplus.ecommerce.model.WishList;
import com.webtutsplus.ecommerce.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class WishListService {

    private final WishListRepository wishListRepository;

    @Autowired
    ProductService productService;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<ProductDto> getWishListForUser(User user) {
        final List<WishList> wishLists = wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> productDtos = new ArrayList<>();
        for (WishList wishList: wishLists) {
            productDtos.add(productService.getProductDto(wishList.getProduct()));
        }

        return productDtos;
    }
}
