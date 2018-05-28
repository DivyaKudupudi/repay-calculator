package com.suncorp.repaycalculator.repository;

import com.suncorp.repaycalculator.Entity.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepayCalcRepository extends JpaRepository<CommonCode, Integer> {

}
