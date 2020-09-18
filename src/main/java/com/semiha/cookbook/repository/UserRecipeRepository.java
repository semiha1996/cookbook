package com.semiha.cookbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.semiha.cookbook.entity.UserRecipe;

@Repository
public interface UserRecipeRepository extends JpaRepository<UserRecipe, Long> {

	@Query("SELECT a FROM UserRecipe a WHERE a.id = :id")
	List<UserRecipe> getUserRecipeById(@Param("id") Long id);

	@Query("SELECT a FROM UserRecipe a WHERE a.user.userId = :user_id AND a.isSaved=:isSaved")
	List<UserRecipe> getAllPlansByName(@Param("user_id") Long userId, @Param("isSaved") boolean isSaved);
}
 