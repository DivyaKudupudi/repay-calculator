package com.suncorp.repaycalculator.controller;

import com.suncorp.repaycalculator.request.RepayCalcRequest;
import com.suncorp.repaycalculator.response.RepayCalcResponse;
import com.suncorp.repaycalculator.service.RepayCalService;
import com.suncorp.repaycalculator.dto.CommonCodeMapBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.suncorp.repaycalculator.constants.RepayCalcConstants.LOAN_PERIOD_CODE_TYPE;
import static com.suncorp.repaycalculator.constants.RepayCalcConstants.LOAN_PURPOSE_CODE_TYPE;
import static com.suncorp.repaycalculator.constants.RepayCalcConstants.LOAN_TYPE_CODE_TYPE;

@RestController
@RequestMapping("/api/repay/")
public class RepayCalController {

    @Autowired
    private RepayCalService repayCalService;

    @RequestMapping(value="calculate",method = RequestMethod.POST)
    public RepayCalcResponse calculateRepayment(RepayCalcRequest repayCalcRequest){
        return repayCalService.calculateRepayment(repayCalcRequest);
    }

    @RequestMapping(value="loanPeriod", method = RequestMethod.GET)
    public List<CommonCodeMapBean> getLoanPeriodDropDown(){
        return repayCalService.getLoanPeriodDropDown(LOAN_PERIOD_CODE_TYPE);
    }

    @RequestMapping(value="loanTypes", method = RequestMethod.GET)
    public List<CommonCodeMapBean> getLoanTypeDropDown(){
        return repayCalService.getLoanTypeDropDown(LOAN_TYPE_CODE_TYPE);
    }

    @RequestMapping(value="loanPurpose", method = RequestMethod.GET)
    public  List<CommonCodeMapBean> getLoanPurposeDropDown(){
        return repayCalService.getLoanPurposeDropDown(LOAN_PURPOSE_CODE_TYPE);
    }
}
