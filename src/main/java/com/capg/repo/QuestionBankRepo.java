package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.QuestionBank;

public interface QuestionBankRepo  extends JpaRepository<QuestionBank,Integer> {

}

