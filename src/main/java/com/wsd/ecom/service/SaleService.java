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
public interface SaleService {

	public Sale getSale(Long id);

	public double getSaleByDate(Date date);

	public Sale getSaleByDateRange(Date startdate, Date enddate);

	public List<Sale> getAllTopSaleByTotalPrice();

	public List<Sale> getLastMonthTopSaleByTotalUnit();
}