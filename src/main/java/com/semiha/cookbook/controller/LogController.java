package com.semiha.cookbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.semiha.cookbook.classes.Errors;
import com.semiha.cookbook.classes.RegistrationModel;
import com.semiha.cookbook.service.UserService;


@Controller
public class LogController {

	 @Autowired
	    private UserService userService;

	    @GetMapping("/register")
	    public String getRegisterPage(@ModelAttribute RegistrationModel registrationModel){
	        return "register";
	    }

	    @PostMapping("/register")
	    public String registerUser(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult){
	        if(bindingResult.hasErrors()){
	            return "register";
	        }

	        this.userService.register(registrationModel);

	        return "redirect:/";
	    }

	@GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", Errors.INVALID_CREDENTIALS);
        }

        return "login";
    }

}
