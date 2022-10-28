package com.gsg.finance.service;

import com.gsg.finance.controller.exception.TaxRateNotFound;
import com.gsg.finance.dto.FinanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FinanceService {

    @Autowired
    TaxRateProviderService taxRateProviderService;

    public FinanceDTO calculateNetPrice(double grossPrice, String countryIso) throws TaxRateNotFound {
        double taxRate = taxRateProviderService.taxRateProvider(countryIso);
        if(taxRate < 0){
            throw new TaxRateNotFound();
        }
        double netPrice =  grossPrice - (grossPrice*taxRate);
        return new FinanceDTO(netPrice);
    }
}
