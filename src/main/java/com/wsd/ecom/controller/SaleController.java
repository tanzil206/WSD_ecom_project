package com.wsd.ecom.controller;

import com.wsd.ecom.entity.Sale;
import com.wsd.ecom.exception.SaleNotFoundException;
import com.wsd.ecom.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j

@RequestMapping("/api/product/sale")
public class SaleController {

	@Autowired
	private SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@GetMapping("/currentdate")
	public ResponseEntity<?> getCurretDaySale() throws ParseException {

		double totalSaleamount = 0;

		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		Date currentdate = (Date) dt.parse(currentDate);
		try {
			totalSaleamount = saleService.getSaleByDate(currentdate);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return new ResponseEntity<>("No sale record found for today", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("totalSale:" + totalSaleamount, HttpStatus.OK);

	}

	@GetMapping("/daterange")
	public ResponseEntity<?> getSaleByDateRange(@RequestParam String startDate, @RequestParam String endDate)
			throws ParseException {
		Sale sale = new Sale();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		Date startdate = (Date) dt.parse(startDate);
		Date enddate = (Date) dt.parse(endDate);

		log.info("Start date " + startDate + "End date :" +endDate);
		try {
			sale = saleService.getSaleByDateRange(startdate, enddate); /* Call service for get sale date between date range*/
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(sale, HttpStatus.OK);

	}

	@GetMapping("/alltime")
	public ResponseEntity<?> getSaleByAllTime() {
		List<Sale> productSaleList = new ArrayList<>();

		try {
			productSaleList = saleService.getAllTopSaleByTotalPrice();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(productSaleList, HttpStatus.OK);
	}

	@GetMapping("/lastMonth")
	public ResponseEntity<?> getSaleLastMonth() {
		List<Sale> productSaleList = new ArrayList<>();
		try {
			productSaleList = saleService.getLastMonthTopSaleByTotalUnit();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(productSaleList, HttpStatus.OK);
	}
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void SaleNotFound(SaleNotFoundException e) {
		log.error("Sale not found", e);
	}

}
