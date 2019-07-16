package com.tanjie.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.tanjie.demo.domain.ExeciseEntryGroup;


/**
 * Spring Data  repository for the ExeciseEntryGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExeciseEntryGroupRepository extends JpaRepository<ExeciseEntryGroup, Long> {

}
