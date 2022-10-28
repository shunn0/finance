package com.gsg.finance.dto;

public class FinanceDTO {

    private double netPrice;

    public FinanceDTO(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

}
