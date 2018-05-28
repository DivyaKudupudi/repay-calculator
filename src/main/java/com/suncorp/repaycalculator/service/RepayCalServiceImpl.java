package com.suncorp.repaycalculator.service;

import com.suncorp.repaycalculator.dao.RepayCalcDao;
import com.suncorp.repaycalculator.request.LoanAmount;
import com.suncorp.repaycalculator.request.RepayCalcRequest;
import com.suncorp.repaycalculator.dto.CommonCodeMapBean;
import com.suncorp.repaycalculator.response.LoanRate;
import com.suncorp.repaycalculator.response.RepayCalcResponse;
import com.suncorp.repaycalculator.response.ServiceFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepayCalServiceImpl implements RepayCalService {

    @Autowired
    private RepayCalcDao repayCalcDao;

    @Override
    public RepayCalcResponse calculateRepayment(RepayCalcRequest repayCalcRequest) {
        RepayCalcResponse repayCalcResponse = new RepayCalcResponse();
        LoanRate comparisionRate = new LoanRate();
        comparisionRate.setPeriodType("p.a");
        comparisionRate.setRate(BigDecimal.valueOf(6.59));
        comparisionRate.setUnit('%');
        repayCalcResponse.setComparisionRate(comparisionRate);
        LoanAmount establishFee = new LoanAmount();
        establishFee.setAmount(BigDecimal.valueOf(175));
        establishFee.setCurrency("USD");
        repayCalcResponse.setEstablishmentFee(establishFee);
        LoanAmount govtCharges = new LoanAmount();
        govtCharges.setCurrency("USD");
        govtCharges.setAmount(BigDecimal.valueOf(6.80));
        repayCalcResponse.setGovtCharges(govtCharges);
        LoanRate interestRate = new LoanRate();
        interestRate.setUnit('%');
        interestRate.setRate(BigDecimal.valueOf(5.99));
        interestRate.setPeriodType("p.a");
        repayCalcResponse.setInterestRate(interestRate);
        ServiceFee serviceFee = new ServiceFee();
        LoanAmount amount = new LoanAmount();
        amount.setAmount(BigDecimal.valueOf(5));
        amount.setCurrency("SGD");
        serviceFee.setAmount(amount);
        serviceFee.setPeriodType("/month");
        repayCalcResponse.setServiceFee(serviceFee);
        LoanAmount totalAmount = new LoanAmount();
        totalAmount.setCurrency("USD");
        totalAmount.setAmount(BigDecimal.valueOf(10181.80));
        repayCalcResponse.setTotalAmount(totalAmount);
        LoanAmount totalInclFees = new LoanAmount();
        totalInclFees.setAmount(BigDecimal.valueOf(173.69));
        totalInclFees.setCurrency("USD");
        repayCalcResponse.setTotalInclFees(totalInclFees);

        return repayCalcResponse;
    }

    @Override
    public List<CommonCodeMapBean> getLoanPeriodDropDown(String code) {
        List<CommonCodeMapBean> loanPeriodList = new ArrayList<>();
        CommonCodeMapBean loanPeriod = new CommonCodeMapBean();
        loanPeriod.setCode("01");
        loanPeriod.setCodeDesc("5 years");
        loanPeriodList.add(loanPeriod);
        CommonCodeMapBean loanPeriod1 = new CommonCodeMapBean();
        loanPeriod1.setCode("02");
        loanPeriod1.setCodeDesc("6 years");
        loanPeriodList.add(loanPeriod1);
        CommonCodeMapBean loanPeriod2 = new CommonCodeMapBean();
        loanPeriod2.setCode("03");
        loanPeriod2.setCodeDesc("10 years");
        loanPeriodList.add(loanPeriod2);
        return loanPeriodList;
    }

    @Override
    public List<CommonCodeMapBean> getLoanTypeDropDown(String code) {
        List<CommonCodeMapBean> loanTypeList = new ArrayList<>();
        CommonCodeMapBean loanType = new CommonCodeMapBean();
        loanType.setCode("01");
        loanType.setCodeDesc("Secured Car Loan");
        loanTypeList.add(loanType);
        CommonCodeMapBean loanType1 = new CommonCodeMapBean();
        loanType1.setCode("02");
        loanType1.setCodeDesc("Secured Home Loan");
        loanTypeList.add(loanType1);
        return loanTypeList;
    }

    @Override
    public List<CommonCodeMapBean> getLoanPurposeDropDown(String code) {
        List<CommonCodeMapBean> loanPurposeList = new ArrayList<>();
        CommonCodeMapBean loanPurpose = new CommonCodeMapBean();
        loanPurpose.setCode("01");
        loanPurpose.setCodeDesc("Purchase a new car");
        loanPurposeList.add(loanPurpose);
        CommonCodeMapBean loanPurpose1 = new CommonCodeMapBean();
        loanPurpose1.setCode("02");
        loanPurpose1.setCodeDesc("Purchase a new house");
        loanPurposeList.add(loanPurpose1);
        return loanPurposeList;
    }
}
