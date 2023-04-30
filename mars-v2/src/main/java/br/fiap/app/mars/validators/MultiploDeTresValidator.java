package br.fiap.app.mars.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultiploDeTresValidator implements ConstraintValidator<MultiploDeTres, Integer> {
    public void initialize(MultiploDeTres constraint) {
    }

    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % 3 == 0 && value > 0;
    }
}