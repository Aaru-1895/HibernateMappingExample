package com.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.map.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>{

	/* Tutorial save(Tutorial tutorial); */

}
