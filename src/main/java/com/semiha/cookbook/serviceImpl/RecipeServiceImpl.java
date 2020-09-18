package com.semiha.cookbook.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semiha.cookbook.repository.RecipeRepository;
import com.semiha.cookbook.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;
}
