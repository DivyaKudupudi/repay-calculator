package com.suncorp.repaycalculator.response;

import com.suncorp.repaycalculator.request.LoanAmount;

/**
 * @author Divya
 */
public class RepayCalcResponse {

    private LoanAmount totalInclFees;
    private LoanRate interestRate;
    private LoanRate comparisionRate;
    private LoanAmount totalAmount;
    private LoanAmount establishmentFee;
    private LoanAmount govtCharges;
    private ServiceFee serviceFee;

    public LoanAmount getTotalInclFees() {
        return totalInclFees;
    }

    public void setTotalInclFees(LoanAmount totalInclFees) {
        this.totalInclFees = totalInclFees;
    }

    public LoanRate getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(LoanRate interestRate) {
        this.interestRate = interestRate;
    }

    public LoanRate getComparisionRate() {
        return comparisionRate;
    }

    public void setComparisionRate(LoanRate comparisionRate) {
        this.comparisionRate = comparisionRate;
    }

    public LoanAmount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(LoanAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LoanAmount getEstablishmentFee() {
        return establishmentFee;
    }

    public void setEstablishmentFee(LoanAmount establishmentFee) {
        this.establishmentFee = establishmentFee;
    }

    public LoanAmount getGovtCharges() {
        return govtCharges;
    }

    public void setGovtCharges(LoanAmount govtCharges) {
        this.govtCharges = govtCharges;
    }

    public ServiceFee getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(ServiceFee serviceFee) {
        this.serviceFee = serviceFee;
    }
}
