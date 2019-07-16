package com.tanjie.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.tanjie.demo.domain.ExecisePlan;

import java.util.List;

/**
 * Spring Data  repository for the ExecisePlan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExecisePlanRepository extends JpaRepository<ExecisePlan, Long> {

}
