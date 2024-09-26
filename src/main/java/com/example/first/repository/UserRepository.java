package com.example.first.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.first.dto.request.CreateUserRequest;
import com.example.first.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
	Optional<UsersEntity> findByUserName(String username);

	boolean existsByUserName(String username);

//	@Query(value = "SELECT EXISTS (SELECT 1 FROM users WHERE phone = '?1') AS phone_exists", nativeQuery = true)
//	 ArrayList<int> findByCheckPhone(String phone);
	boolean existsByPhone(String phone);

	@Query(value = "select * from users where phone =?1", nativeQuery = true)
	Optional<UsersEntity> findByPhone(String phone);
}
