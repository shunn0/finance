package com.gsg.finance;

import com.gsg.finance.service.TaxRateProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class, args);

    }

    @Autowired
    TaxRateProviderService taxRateProviderService;
    @PostConstruct
    public void init() {
        taxRateProviderService.loadTaxRateMap();
    }
}