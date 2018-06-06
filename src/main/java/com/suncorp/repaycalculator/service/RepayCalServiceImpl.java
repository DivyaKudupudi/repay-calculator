package com.suncorp.repaycalculator.service;

import com.suncorp.repaycalculator.Entity.CommonCode;
import com.suncorp.repaycalculator.dao.RepayCalcDao;
import com.suncorp.repaycalculator.request.LoanAmount;
import com.suncorp.repaycalculator.request.RepayCalcRequest;
import com.suncorp.repaycalculator.dto.CommonCodeMapBean;
import com.suncorp.repaycalculator.response.LoanRate;
import com.suncorp.repaycalculator.response.RepayCalcResponse;
import com.suncorp.repaycalculator.response.ServiceFee;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Divya
 * @description Service Implementation class for Repayment calculator
 */
@Service
public class RepayCalServiceImpl implements RepayCalService {

    private static final Logger LOG = LoggerFactory.getLogger(RepayCalServiceImpl.class);

    @Autowired
    private RepayCalcDao repayCalcDao;

    @Autowired
    private ModelMapper modelMapper;

    /**
     *
     * @param repayCalcRequest
     * @return Return calculated repayment
     */
    @Override
    public RepayCalcResponse calculateRepayment(RepayCalcRequest repayCalcRequest) {
        LOG.debug("Calculating Repayment start");
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
        LOG.debug("Calculating Repayment end");
        return repayCalcResponse;
    }

    /**
     *
     * @param code
     * @return Return loan period dropdown values for respective code
     */
    @Override
    public List<CommonCodeMapBean> getLoanPeriodDropDown(String code) {
        LOG.debug("Populating Loan period dropdown start");
        List<CommonCode> list = repayCalcDao.getCommonCodes("LOAN_PERIOD");
        LOG.debug("Populating Loan period dropdown end");
        return list.stream()
                .map(commonCode -> convertToMapBean(commonCode))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param code
     * @return Return loan type dropdown values for respective code
     */
    @Override
    public List<CommonCodeMapBean> getLoanTypeDropDown(String code) {
        LOG.debug("Populating Loan Type dropdown start");
        List<CommonCode> list = repayCalcDao.getCommonCodes("LOAN_TYPE");
        LOG.debug("Populating Loan Type dropdown end");
        return list.stream()
                .map(commonCode -> convertToMapBean(commonCode))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param code
     * @return Return loan purpose dropdown values for respective code
     */
    @Override
    public List<CommonCodeMapBean> getLoanPurposeDropDown(String code) {
        LOG.debug("Populating Loan Purpose dropdown start");
        List<CommonCode> list = repayCalcDao.getCommonCodes("LOAN_PURPOSE");
        LOG.debug("Populating Loan Purpose dropdown end");
        return list.stream()
                .map(commonCode -> convertToMapBean(commonCode))
                .collect(Collectors.toList());
    }

    private CommonCodeMapBean convertToMapBean(CommonCode commonCode){
        return modelMapper.map(commonCode, CommonCodeMapBean.class);
    }
}
