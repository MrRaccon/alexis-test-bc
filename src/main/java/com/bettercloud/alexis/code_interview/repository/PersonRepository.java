package com.bettercloud.alexis.code_interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bettercloud.alexis.code_interview.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
