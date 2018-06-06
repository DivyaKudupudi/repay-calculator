package com.suncorp.repaycalculator.request;

import java.math.BigInteger;

/**
 * @author Divya
 */
public class LoanPeriod {
    private BigInteger period;
    private String periodType;

    public BigInteger getPeriod() {
        return period;
    }

    public void setPeriod(BigInteger period) {
        this.period = period;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }
}
