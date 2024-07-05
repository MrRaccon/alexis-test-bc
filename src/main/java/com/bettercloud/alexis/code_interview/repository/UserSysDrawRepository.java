package com.bettercloud.alexis.code_interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bettercloud.alexis.code_interview.model.UserSysDraw;

@Repository
public interface UserSysDrawRepository extends JpaRepository<UserSysDraw, Integer> {
}