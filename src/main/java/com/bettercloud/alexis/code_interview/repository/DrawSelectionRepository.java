package com.bettercloud.alexis.code_interview.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bettercloud.alexis.code_interview.model.DrawSelection;

@Repository
public interface DrawSelectionRepository extends JpaRepository<DrawSelection, Integer> {

    Set<DrawSelection> findByPersonReceivePersonIdInAndYearDrawBetween( List<Integer> personReceiveIds, int startYear, int endYear);
}