package com.semiha.cookbook.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semiha.cookbook.repository.UserRecipeRepository;
import com.semiha.cookbook.service.UserRecipeService;

@Service
public class UserRecipeServiceImpl implements UserRecipeService {
	@Autowired
	private UserRecipeRepository userRecipeRepository;
}
