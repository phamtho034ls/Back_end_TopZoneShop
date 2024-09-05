package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Long>{

}
