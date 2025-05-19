package com.cloud.nativ.networkelements.domain.enums.validator;

import com.cloud.nativ.networkelements.domain.enums.ElementType;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:43 p.m.
 */
public class ElementTypeValueValidator implements ConstraintValidator<ElementTypeValidator, String>  {

    private String errorMessage;

    @Override
    public void initialize(ElementTypeValidator constraintAnnotation) {
        errorMessage = constraintAnnotation.message()//
                .concat(" {")//
                .concat(String.join(", ", ElementType.getMapOfEnumsByValue().keySet()))//
                .concat("}");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = false;
        try {
            ElementType.getEnumByValue(value);
            isValid = true;
        } catch (RuntimeException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
        }
        return isValid;
    }
}
