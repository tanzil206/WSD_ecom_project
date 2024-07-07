package com.wsd.ecom.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.ecom.entity.Sale;
import com.wsd.ecom.exception.SaleNotFoundException;
import com.wsd.ecom.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale getSale(Long id) {
        return saleRepository.findById(id).orElseThrow(SaleNotFoundException::new);
    }
    
    public double getSaleByDate(Date date) {
        return saleRepository.sumTotalPriceBySaleDate(date);
    }
  
    public Sale getSaleByDateRange(Date startdate,Date enddate) {
        return saleRepository.findBySaleDateBetween(startdate,enddate);
    }
    
    public List<Sale> getAllTopSaleByTotalPrice() {

    	
        return saleRepository.findAllByTotalAmount();
    }
    
    public List<Sale> getLastMonthTopSaleByTotalUnit() {
    	Calendar aCalendar = Calendar.getInstance(); /* Find out last month start and end date */
    	aCalendar.set(Calendar.DATE, 1);
    	aCalendar.add(Calendar.DAY_OF_MONTH, -1);
    	Date lastDateOfPreviousMonth = aCalendar.getTime();
    	aCalendar.set(Calendar.DATE, 1);
    	Date firstDateOfPreviousMonth = aCalendar.getTime();
    	
        return saleRepository.findAllBySaleDateBetween(firstDateOfPreviousMonth,lastDateOfPreviousMonth);
    }
}