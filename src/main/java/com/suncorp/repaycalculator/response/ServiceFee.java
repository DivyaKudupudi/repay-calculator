package com.suncorp.repaycalculator.response;

import com.suncorp.repaycalculator.request.LoanAmount;

import java.math.BigDecimal;

/**
 * @author Divya
 */
public class ServiceFee {

    private LoanAmount amount;
    private String periodType;

    public LoanAmount getAmount() {
        return amount;
    }

    public void setAmount(LoanAmount amount) {
        this.amount = amount;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }
}
