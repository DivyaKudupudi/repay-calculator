package com.suncorp.repaycalculator.controller;

import com.suncorp.repaycalculator.constants.RepayCalcConstants;
import com.suncorp.repaycalculator.request.RepayCalcRequest;
import com.suncorp.repaycalculator.response.RepayCalcResponse;
import com.suncorp.repaycalculator.service.RepayCalService;
import com.suncorp.repaycalculator.dto.CommonCodeMapBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.suncorp.repaycalculator.constants.RepayCalcConstants.*;

/**
 * @author Divya
 * @description Controller class for Repayment Calculator API methods
 */
@RestController
@RequestMapping(RepayCalcConstants.BASE_URI)
public class RepayCalController {

    @Autowired
    private RepayCalService repayCalService;

    /**
     *
     * @param repayCalcRequest
     * @return Returns RepayCalcResponse after calculating the amount and interest details
     */
    @PostMapping(value=CALCULATE)
    public RepayCalcResponse calculateRepayment(RepayCalcRequest repayCalcRequest){
        return repayCalService.calculateRepayment(repayCalcRequest);
    }

    /**
     *
     * @return Returns the list of Loan Period dropdown values
     */
    @GetMapping(value=LOAN_PERIOD)
    public List<CommonCodeMapBean> getLoanPeriodDropDown(){
        return repayCalService.getLoanPeriodDropDown(LOAN_PERIOD_CODE_TYPE);
    }

    /**
     *
     * @return Returns the list of Loan Type dropdown values
     */
    @GetMapping(value=LOAN_TYPES, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CommonCodeMapBean> getLoanTypeDropDown(){
        return repayCalService.getLoanTypeDropDown(LOAN_TYPE_CODE_TYPE);
    }

    /**
     *
     * @return Returns the list of Loan Purpose dropdown values
     */
    @GetMapping(value=LOAN_PURPOSE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  List<CommonCodeMapBean> getLoanPurposeDropDown(){
        return repayCalService.getLoanPurposeDropDown(LOAN_PURPOSE_CODE_TYPE);
    }
}
