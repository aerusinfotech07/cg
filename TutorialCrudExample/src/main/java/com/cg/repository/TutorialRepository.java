package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
	
	List<Tutorial> findByType(String type);

	List<Tutorial> findByPublised(boolean published);
	
	@Query(nativeQuery = true,value = "FROM db_tutorial where title like %?0%")
	List<Tutorial> sadsd(String title);

}
