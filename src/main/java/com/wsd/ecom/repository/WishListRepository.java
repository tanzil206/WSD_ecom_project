package com.wsd.ecom.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wsd.ecom.entity.Customer;
import com.wsd.ecom.entity.WishList;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends CrudRepository<WishList, Long> {
    Optional<WishList> findById(Long id);
    
	List<WishList> findByCustomer(Customer customer);
}
