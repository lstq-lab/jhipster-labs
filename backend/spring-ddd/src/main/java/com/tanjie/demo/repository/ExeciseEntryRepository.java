package com.tanjie.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.tanjie.demo.domain.ExeciseEntry;


/**
 * Spring Data  repository for the ExeciseEntry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExeciseEntryRepository extends JpaRepository<ExeciseEntry, Long> {

}
