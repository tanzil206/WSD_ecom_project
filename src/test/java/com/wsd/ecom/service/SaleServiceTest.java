package com.wsd.ecom.service;

import com.wsd.ecom.entity.Sale;
import com.wsd.ecom.exception.SaleNotFoundException;
import com.wsd.ecom.repository.SaleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
public class SaleServiceTest {

    @Autowired
    private SaleService saleService;

    @MockBean
    private SaleRepository saleRepository;

    @Test
    void should_return_Sale_details() {
        given(saleRepository.findById(anyLong())).willReturn(java.util.Optional.of(new Sale()));
        assertThat(saleService.getSale(1L)).isNotNull();
    }

    @Test
    void should_not_return_Sale_details_if_not_present() {
        given(saleRepository.findById(anyLong())).willThrow(SaleNotFoundException.class);
        assertThrows(SaleNotFoundException.class, () -> saleService.getSale(50L));
    }

}
