package com.wsd.ecom.controller;


import com.wsd.ecom.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



@WebMvcTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class SaleControllerTest {

    @Autowired
    private MockMvc mockRequest;

    @MockBean
    private SaleService SaleService;

 

}
