package com.gsg.finance.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class FinanceServiceTest {

    @MockBean
    TaxRateProviderService taxRateProviderService;

    @Autowired
    FinanceService financeService;

    @Test
    public void testCalculateNetPriceNormalMockedRate(){
        Mockito.when(taxRateProviderService.taxRateProvider("UK")).thenReturn(0.10);
        double netPrice = financeService.calculateNetPrice(200, "UK");
        Assertions.assertEquals(180, netPrice);
    }

    @Test
    public void testCalculateNetPriceMaxIntPrice(){
        double netPrice = financeService.calculateNetPrice(Integer.MAX_VALUE, "UK");
        Assertions.assertEquals(2.147483647E9, netPrice);
    }

    @Test
    public void testCalculateNetPriceMaxDoublePrice(){
        double netPrice = financeService.calculateNetPrice(Double.MAX_VALUE, "UK");
        Assertions.assertEquals(1.7976931348623157E308, netPrice);
    }

}