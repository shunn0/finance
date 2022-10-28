package com.gsg.finance.service;

import com.gsg.finance.controller.exception.TaxRateNotFound;
import com.gsg.finance.dto.FinanceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinanceServiceTest {

    @Autowired
    FinanceService financeService;

    @Test
    public void testCalculateNetPriceNormalMockedRate() throws TaxRateNotFound {
        FinanceDTO netPrice = financeService.calculateNetPrice(200, "DE");
        Assertions.assertEquals(162.0, netPrice.getNetPrice());
    }
    @Test
    public void testCalculateNetPriceNormalMockedRate2() throws TaxRateNotFound {

        Exception exception = Assertions.assertThrows(TaxRateNotFound.class,
                () -> {
                    financeService.calculateNetPrice(200, "IN");
                }
                );
        String expectedMessage = "Tax Rate for provided country missing";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCalculateNetPriceMaxIntPrice() throws TaxRateNotFound {
        FinanceDTO netPrice = financeService.calculateNetPrice(Integer.MAX_VALUE, "UK");
        Assertions.assertEquals(1.9327352823E9, netPrice.getNetPrice());
    }

    @Test
    public void testCalculateNetPriceMaxDoublePrice() throws TaxRateNotFound {
        FinanceDTO netPrice = financeService.calculateNetPrice(Double.MAX_VALUE, "UK");
        Assertions.assertEquals(1.6179238213760842E308, netPrice.getNetPrice());
    }

}