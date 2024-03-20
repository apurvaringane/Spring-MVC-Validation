package org.jspiders.SpringMVCValidation.domain;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.valves.rewrite.Substitution;
import org.jspiders.SpringMVCValidation.validation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @NotBlank(message = "INVALID EMPLOYEE ID")
    @Id(message = "ID MUST START WITH QSP")
    private String empId;
    @NotBlank(message = "INVALID EMPLOYEE NAME")
   @Size(min = 2, message = "Minimum 2 characters required")
   private String firstName;
    @NotBlank(message = "INVALID LAST NAME")
    private String lastName;


   @NotNull(message = "INVALID SALARY")
    @Positive(message = "value must be positive")
    private double salary;

   @NotNull(message = "INVALID DATE")
   @Past(message = "date must be past")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;

   public String getJoin()
   {
       SimpleDateFormat sd=new SimpleDateFormat("yyyy-mm-dd");
       return sd.format(joinDate);
   }

}
//Cross field validation
//The process of validating one text to another text
//field by using the value of another text field is known as crosss field validation