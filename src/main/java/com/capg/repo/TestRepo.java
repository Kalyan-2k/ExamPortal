package com.capg.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Category;
import com.capg.entity.Test;

public interface TestRepo  extends JpaRepository<Test,Integer>{

	public List<Test> findByCategory(Category category);

}
