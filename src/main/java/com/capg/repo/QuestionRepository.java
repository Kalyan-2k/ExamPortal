package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer>{

}
