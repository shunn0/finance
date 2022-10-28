package com.gsg.finance.controller;

import com.gsg.finance.controller.exception.TaxRateNotFound;
import com.gsg.finance.dto.FinanceDTO;
import com.gsg.finance.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
@CrossOrigin(origins = "http://localhost:3000")
public class FinanceController {

    @Autowired
    FinanceService financeService;

    @GetMapping("/netprice")
    public ResponseEntity getNetPrice(Double grossPrice, String countryIso) {
        try {
            FinanceDTO netPriceDTO = financeService.calculateNetPrice(grossPrice, countryIso);
            return ResponseEntity.ok().body(netPriceDTO);
        } catch (TaxRateNotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
