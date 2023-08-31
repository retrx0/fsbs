package com.nsi.validators;

import com.nsi.annotations.PasswordMatches;
import com.nsi.dto.UserRegistrationDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserRegistrationDTO userRegistrationDTO = (UserRegistrationDTO) o;
        return userRegistrationDTO.getPassword().equals(userRegistrationDTO.getMatchingPassword());
    }
}
