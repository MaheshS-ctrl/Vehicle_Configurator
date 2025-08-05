package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Alternate_Component_Master;

@Repository
public interface Alternate_Component_MasterRepository extends JpaRepository<Alternate_Component_Master, Integer>{
	@Query(value="select * from alternate_component_master where model_id=:mdId",nativeQuery = true)
	List<Alternate_Component_Master> findAltCompByModelId(@Param("mdId") Integer mdId);
	
	@Query(value="select * from alternate_component_master where comp_id=:compId", nativeQuery = true)
	List<Alternate_Component_Master> findAltCompByComponentId(@Param("compId") Integer compId);
}
