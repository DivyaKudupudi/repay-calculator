package com.suncorp.repaycalculator.service;

import com.suncorp.repaycalculator.dto.CommonCodeMapBean;
import com.suncorp.repaycalculator.request.RepayCalcRequest;
import com.suncorp.repaycalculator.response.RepayCalcResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Divya
 */
public interface RepayCalService {
    RepayCalcResponse calculateRepayment(RepayCalcRequest repayCalcRequest);
    List<CommonCodeMapBean> getLoanPeriodDropDown(String code);
    List<CommonCodeMapBean> getLoanTypeDropDown(String code);
    List<CommonCodeMapBean> getLoanPurposeDropDown(String code);
}
