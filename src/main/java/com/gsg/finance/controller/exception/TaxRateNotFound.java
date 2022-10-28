package com.gsg.finance.controller.exception;

public class TaxRateNotFound extends Exception {
    public TaxRateNotFound(String message) {
        super(message);
    }

    public TaxRateNotFound() {
        super("Tax Rate for provided country missing Exception.");
    }
}
