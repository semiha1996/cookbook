package com.semiha.cookbook.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.semiha.cookbook.classes.RegistrationModel;

public interface UserService extends UserDetailsService {

	 void register(RegistrationModel registrationModel);

	    @PreAuthorize("hasRole('ADMIN')")
	    void delete();
}
