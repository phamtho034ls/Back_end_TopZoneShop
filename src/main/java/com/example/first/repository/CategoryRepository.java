package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.first.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
	@Query(value = "select categorys.id from categorys where name= ?1", nativeQuery = true)
	public Long findByName(String name);
}
