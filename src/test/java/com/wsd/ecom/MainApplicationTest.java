package com.wsd.ecom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainApplicationTest {

    @Test
    void should_start_main_application_successfully() {
        MainApplication.main(new String[]{});
    }
}
