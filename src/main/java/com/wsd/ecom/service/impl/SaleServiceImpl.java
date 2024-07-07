package com.wsd.ecom.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.ecom.entity.Sale;
import com.wsd.ecom.exception.SaleNotFoundException;
import com.wsd.ecom.repository.SaleRepository;
import com.wsd.ecom.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService{

	@Autowired
    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale getSale(Long id) {
        return saleRepository.findById(id).orElseThrow(SaleNotFoundException::new);
    }
    
    @Override
    public double getSaleByDate(Date date) {
        return saleRepository.sumTotalPriceBySaleDate(date);
    }
  
    @Override
    public Sale getSaleByDateRange(Date startdate,Date enddate) {
        return saleRepository.findBySaleDateBetween(startdate,enddate);
    }
    
    @Override
    public List<Sale> getAllTopSaleByTotalPrice() {

    	
        return saleRepository.findAllByTotalAmount();
    }
    
    @Override
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