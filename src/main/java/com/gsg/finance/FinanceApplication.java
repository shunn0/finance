package com.gsg.finance;

import com.gsg.finance.service.TaxRateProviderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class, args);

    }

    @PostConstruct
    public void init() {
        TaxRateProviderService.loadTaxRateMap();
    }
}