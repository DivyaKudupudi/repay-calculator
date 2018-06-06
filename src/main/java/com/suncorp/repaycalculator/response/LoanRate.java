package com.suncorp.repaycalculator.response;

import java.math.BigDecimal;

/**
 * @author Divya
 */
public class LoanRate {

    private BigDecimal rate;
    private String periodType;
    private char unit;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public char getUnit() {
        return unit;
    }

    public void setUnit(char unit) {
        this.unit = unit;
    }
}
