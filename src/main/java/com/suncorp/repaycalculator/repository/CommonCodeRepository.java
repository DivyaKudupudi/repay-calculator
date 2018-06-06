package com.suncorp.repaycalculator.repository;

import com.suncorp.repaycalculator.Entity.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Divya
 * @description Repository to access the database tables data
 */

@Transactional
public interface CommonCodeRepository extends JpaRepository<CommonCode, Long> {
    public List<CommonCode> getCommonCodesByCodeType(String codeType);
}
