package com.capg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer>{
	
	@Query(value="select * from questions where category_id=:categoryId and is_active=true order by random() limit :numOfQuestions",nativeQuery =true)
	List<Question> fetchQuestionsAtRandom(@Param("categoryId") int categoryId,@Param("numOfQuestions") int numOfQuestions);
}
