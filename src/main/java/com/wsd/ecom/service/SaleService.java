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

}