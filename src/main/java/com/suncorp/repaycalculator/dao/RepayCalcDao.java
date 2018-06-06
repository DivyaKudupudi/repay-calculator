package com.suncorp.repaycalculator.dao;

import com.suncorp.repaycalculator.Entity.CommonCode;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Divya
 * @description DAO interface for accessing entities
 */
@Component
public interface RepayCalcDao {
    public List<CommonCode> getCommonCodes(String codeType);
}
