package com.semiha.cookbook.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.semiha.cookbook.classes.RegistrationModel;


public class IsPasswordsMatchingValidator implements ConstraintValidator<IsPasswordsMatching, Object> {
    @Override
    public void initialize(IsPasswordsMatching isPasswordsMatching) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext constraintValidatorContext) {
        if(userClass instanceof RegistrationModel){
            return ((RegistrationModel) userClass).getPassword().equals(((RegistrationModel) userClass).getConfirmPassword());
        }

        return false;
    }
}