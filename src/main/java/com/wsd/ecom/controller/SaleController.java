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

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void SaleNotFound(SaleNotFoundException e) {
		log.error("Sale not found", e);
	}

}
