package com.semiha.cookbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.semiha.cookbook.entity.Recipe;

@Repository
public interface CommentRepository extends JpaRepository<Recipe, Long> {

	@Query("SELECT a FROM Comment a WHERE a.id = :id")
	List<Recipe> getCommentById(@Param("id") Long id);

	@Query("SELECT a FROM Comment a WHERE a.user.userId = :user_id")
	List<Recipe> getCommentByUserId(@Param("user_id") Long id);

}
