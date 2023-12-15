package com.capg.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.Category;
import com.capg.entity.Tests;

public interface TestRepo  extends JpaRepository<Tests,Integer>{
	
  public List<Tests> findByCategory(Category category);
  
//	@Query(value="select * from test where category_id=:categoryId",nativeQuery=true)
//	List<Tests> getTestsByCategoryId(@Param("categoryId") int categoryId);
}
