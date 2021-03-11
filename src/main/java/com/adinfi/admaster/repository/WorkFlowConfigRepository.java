package com.adinfi.admaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adinfi.admaster.domain.workflow.StageConfig;
import com.adinfi.admaster.domain.workflow.WorkFlow;
import com.adinfi.admaster.domain.workflow.WorkFlowConfig;

public interface WorkFlowConfigRepository extends JpaRepository<WorkFlowConfig, Long> {
	List<WorkFlowConfig> findByWorkFlowAndStageConfigAndValueCode(WorkFlow workFlow, StageConfig stageConfig, String valueCode);
}
