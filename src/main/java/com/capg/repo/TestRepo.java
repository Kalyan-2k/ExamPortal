package com.capg.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Category;
import com.capg.entity.Tests;

public interface TestRepo  extends JpaRepository<Tests,Integer>{

	public List<Tests> findByCategory(Category category);

}
