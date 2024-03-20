package org.jspiders.SpringMVCValidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class GradeValidator implements ConstraintValidator<Grade,String> {
    List<String> grades=new ArrayList<>();

    {
        grades.add("A+");
        grades.add("A");
        grades.add("A-");
        grades.add("B+");
        grades.add("B");
        grades.add("B-");
        grades.add("C+");
        grades.add("C");
        grades.add("C-");
    }

    @Override
    public boolean isValid(String grade, ConstraintValidatorContext constraintValidatorContext) {
        for (String s:grades) {
            if (s.equals(grade)) {
                return true;
            }
        }
            return false;
    }
}
