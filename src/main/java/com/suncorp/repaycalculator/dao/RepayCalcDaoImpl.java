package com.suncorp.repaycalculator.dao;

import com.suncorp.repaycalculator.Entity.CommonCode;
import com.suncorp.repaycalculator.repository.CommonCodeRepository;
import com.suncorp.repaycalculator.repository.RepayCalcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Divya
 * @description DAO Implementation to work with entity classes
 */
@Service
//@Transactional
public class RepayCalcDaoImpl implements RepayCalcDao {

    @Autowired
    private CommonCodeRepository commonCodeRepository;

    @Override
    public List<CommonCode> getCommonCodes(String codeType) {
        return commonCodeRepository.getCommonCodesByCodeType(codeType);
    }
}
