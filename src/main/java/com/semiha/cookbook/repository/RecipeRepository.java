package com.semiha.cookbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.semiha.cookbook.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	@Query("SELECT a FROM Recipe a WHERE a.recipeId = :id")
	List<Recipe> getRecipeById(@Param("id") Long id);

	@Query("SELECT a FROM Recipe a WHERE lower(a.recipeName) LIKE %:searchTerm%")
	List<Recipe> getAllRecipesByName(@Param("searchTerm") String searchTerm);
}
