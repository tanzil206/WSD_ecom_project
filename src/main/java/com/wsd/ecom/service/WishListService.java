package com.wsd.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.ecom.entity.WishList;
import com.wsd.ecom.exception.SaleNotFoundException;
import com.wsd.ecom.repository.WishListRepository;

@Service
public class WishListService {

	@Autowired
    private WishListRepository WishListRepository;

    public WishListService(WishListRepository WishListRepository) {
        this.WishListRepository = WishListRepository;
    }

    public WishList getWishList(Long id) {
        return WishListRepository.findById(id).orElseThrow(SaleNotFoundException::new);
    }
}