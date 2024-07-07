package com.wsd.ecom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wsd.ecom.entity.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Optional<Customer> findById(Long id);

	Optional<Customer> findByUserName(String userName);
}
