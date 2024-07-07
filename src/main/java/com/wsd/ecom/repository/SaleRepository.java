package com.wsd.ecom.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wsd.ecom.entity.Sale;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {
	Optional<Sale> findById(Long id);

}
