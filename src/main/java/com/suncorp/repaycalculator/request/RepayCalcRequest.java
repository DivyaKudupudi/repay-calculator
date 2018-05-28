package com.suncorp.repaycalculator.request;

public class RepayCalcRequest {

    private String loanPurpose;
    private LoanAmount loanAmount;
    private LoanPeriod loanPeriod;
    private String loanType;

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public LoanAmount getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(LoanAmount loanAmount) {
        this.loanAmount = loanAmount;
    }

    public LoanPeriod getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(LoanPeriod loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
}
