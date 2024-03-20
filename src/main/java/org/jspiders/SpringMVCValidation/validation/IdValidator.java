package org.jspiders.SpringMVCValidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class IdValidator implements ConstraintValidator<Id,String> {


//    List<String> id=new ArrayList<>();
//    {
//        id.add("QSP ");
//    }
    @Override
    public boolean isValid(String empId, ConstraintValidatorContext constraintValidatorContext) {
        if (empId==null) {
            return true;
        }
        String requiredPrefix = "QSP";
        return empId.startsWith(requiredPrefix) && empId.substring(requiredPrefix.length()).matches("[a-zA-Z0-9]+");
       // return false;
    }
}
