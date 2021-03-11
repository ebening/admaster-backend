package com.adinfi.admaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.workflow.WorkFlow;

public interface WorkFlowRepository extends JpaRepository<WorkFlow, Long> {
	WorkFlow findByWorkFlowId(Long WorkFlowId);
}
