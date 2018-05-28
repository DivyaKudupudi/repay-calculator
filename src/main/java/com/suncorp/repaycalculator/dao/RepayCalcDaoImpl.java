package com.suncorp.repaycalculator.dao;

import com.suncorp.repaycalculator.repository.RepayCalcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RepayCalcDaoImpl implements RepayCalcDao {

    @Autowired
    private RepayCalcRepository repayCalcRepository;
}
