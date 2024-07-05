package com.bettercloud.alexis.code_interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bettercloud.alexis.code_interview.model.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {
	
    @EntityGraph(attributePaths = "members")
    List<Family> findByUserSysDrawUserSysDrawId(int userSysDrawId);
}
