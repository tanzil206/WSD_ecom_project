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

    /*Get the total sale amount of the current day.*/
    @Query("select sum(s.totalPrice) from Sale s where s.saleDate = :saleDate")
	double sumTotalPriceBySaleDate(@Param("saleDate") Date date);
    
    /* Get the max sale day of a certain time range.*/ 
    @Query("select s,sum(s.totalPrice) from Sale s where (s.saleDate between :startDate AND :endDate) group by s.saleDate order by sum(s.totalPrice) desc limit 1")
    Sale findBySaleDateBetween(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
    
    /* Get top 5 selling items of all time (based on total sale amount).*/
    @Query("select s, sum(s.totalPrice) from Sale s group by s.product.id order by sum(s.totalPrice) desc limit 5")
    List<Sale> findAllByTotalAmount();
    
    /* Get top 5 selling items of the last month (based on number of sales)*/
    @Query("select s,sum(s.totalAmount) from Sale s where (s.saleDate between :startDate AND :endDate) group by s.product.id order by sum(s.totalAmount) desc limit 5")
    List<Sale> findAllBySaleDateBetween(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
    
  
}
