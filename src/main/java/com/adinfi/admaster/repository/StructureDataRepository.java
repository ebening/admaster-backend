package com.adinfi.admaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adinfi.admaster.domain.StructureData;

public interface StructureDataRepository extends JpaRepository<StructureData, Long> {
	StructureData findByDataId(Long dataId);
	List<StructureData> findByActiveOrderByDataIdDesc(Boolean active);
	
	@Query("SELECT SD FROM StructureData SD, StructureDataHistory SDH, WorkFlowConfig WC WHERE SD.dataId = SDH.dataId AND SDH.active = 1 AND SDH.workFlowConfig.workflowConfigId = WC.workflowConfigId AND (((SELECT COUNT(*) FROM StageConfigProfile ISCP WHERE ISCP.stageConfigId = WC.nextStageConfig) = 0)OR((SELECT COUNT(*) FROM StageConfigProfile ISCP, UsuariosPerfiles IUP WHERE ISCP.stageConfigId = WC.nextStageConfig AND ISCP.profileId = IUP.perfilesId AND IUP.usuariosId = :usuarioId) > 0) OR ((SELECT COUNT(*) FROM UsuariosPerfiles WHERE usuariosId = :usuarioId AND perfilesId IN (SELECT valor FROM Parametros WHERE nombre = 'idPerfilAdministrador')) > 0)) ORDER BY SD.dataId DESC")
	List<StructureData> loadInboxInfo(@Param("usuarioId") Long usuariosId);
	
	
}