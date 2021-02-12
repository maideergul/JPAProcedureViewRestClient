package com.works.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.works.entities.ActorProc;

public interface ActorProcRepository extends JpaRepository<ActorProc, Integer> {
	
	@Query(value = "CALL Actor_proc(:actor_name)", nativeQuery = true)
	List<ActorProc> getAllActorFilm( @Param("actor_name") String actor_name );
}
