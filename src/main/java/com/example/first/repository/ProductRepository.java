package com.example.first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.first.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {



//	public List<ProductEntity> findByCid(Long id);

	@Query(value = "SELECT * FROM products where cid = ?1", nativeQuery = true)
	public List<ProductEntity> findByCid(Long id);
	@Query(value = "select categorys.id from categorys where name= ?1", nativeQuery = true)
	public Long findByName(String name);
}
