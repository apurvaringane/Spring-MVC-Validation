package org.jspiders.SpringMVCValidation.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspiders.SpringMVCValidation.validation.Grade;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @NotBlank(message = "INVALID STUDENT NAME")
    @Pattern(regexp = "^[A-Za-z]*$",message = "Only characters are allowed")
    private String studentName;
    @NotBlank(message = "INVALID SUBJECT NAME")
    @Pattern(regexp = "^[A-Za-z]*$",message = "Only characters are allowed")
    private String subject;
    @NotBlank(message = "INVALID GRADE")
   // @Pattern(regexp = "^[A-Za-z]*$",message = "Only characters are allowed")(
    @Grade(message = "INVALID GRADE")
    private String grade;
    @NotBlank(message = "INVALID CONTACT NUMBER")
    @Pattern(regexp = "^[0-9]*$", message = "Only numbers are allowed")
    private String contact;

}

//    List<String> grades=new ArrayList<>()
//    {
//        grades.add
//    }
//    @Override
//    public boolean isValid(String grade, ConstraintValidatorContext constraintValidatorContext) {
//        return false;

