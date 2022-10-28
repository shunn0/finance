package com.gsg.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FinanceService {

    @Autowired
    TaxRateProviderService taxRateProviderService;

    public double calculateNetPrice(double grossPrice, String countryIso){
        double taxRate = taxRateProviderService.taxRateProvider(countryIso);
        return  grossPrice - (grossPrice*taxRate);
//        double d = grossPrice * taxRate;
//        d = grossPrice - d;
//        return d;
    }
}
