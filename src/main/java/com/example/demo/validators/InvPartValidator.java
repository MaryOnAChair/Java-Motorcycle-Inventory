package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InvPartValidator implements ConstraintValidator<ValidInv, Part> {
    @Override
    public void initialize(ValidInv constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        //inventory between min and max

       if (part.getInv() >= part.getMaxInv()) {
            //display error message
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is greater than Max, Please Fix :)").addConstraintViolation();
            return false;
        } else  if (part.getInv() <= part.getMinInv()) {
            //display error message
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is Less than Min, Please Fix :)").addConstraintViolation();
            return false;}
        else {return true;}
    }
}
