package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.entity.Oders;

public interface OdersRepository extends JpaRepository<Oders, Long>{
	
}
