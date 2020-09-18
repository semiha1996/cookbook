package com.semiha.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.semiha.cookbook.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT a FROM User a WHERE a.username = :username ")
	User findUserByUsername(@Param("username") String username);
}
