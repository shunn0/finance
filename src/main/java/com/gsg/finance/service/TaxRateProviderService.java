package com.gsg.finance.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaxRateProviderService {

    private Map<String, Double> countryTaxRateMap = new ConcurrentHashMap<>();

    public double taxRateProvider(String countryIso) {
        if (countryTaxRateMap.containsKey(countryIso)) {
            return countryTaxRateMap.get(countryIso);
        } else {
            return -1.0;
        }
    }


    public void loadTaxRateMap() {
        countryTaxRateMap.put("DE", 0.19);
        countryTaxRateMap.put("FR", 0.20);
        countryTaxRateMap.put("UK", 0.10);
        countryTaxRateMap.put("IR", 0.25);
    }
}
