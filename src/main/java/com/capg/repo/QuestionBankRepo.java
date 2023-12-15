package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.QuestionBank;

public interface QuestionBankRepo  extends JpaRepository<QuestionBank,Integer> {

	@Query(value="select * from questionbank where questionbank_name=:questionBankName",nativeQuery=true)
	QuestionBank getQuestionBankByName(@Param("questionBankName") String questionBankName);

	boolean existsByQuestionBankName(String questionBankName);

}

