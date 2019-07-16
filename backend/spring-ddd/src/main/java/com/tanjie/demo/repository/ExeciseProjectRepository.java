package com.tanjie.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.tanjie.demo.domain.ExeciseProject;

import java.util.List;

/**
 * Spring Data  repository for the ExeciseProject entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExeciseProjectRepository extends JpaRepository<ExeciseProject, Long> {

    
}
