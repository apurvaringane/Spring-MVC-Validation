package org.jspiders.SpringMVCValidation.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import org.jspiders.SpringMVCValidation.domain.Employee;
import org.jspiders.SpringMVCValidation.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private List<Student> studentList=new ArrayList<>();
    private List<Employee> employeeList=new ArrayList<>();



    @GetMapping("/")
    public String getStudentForm(Model model){
        model.addAttribute("student",new Student());
        return "studentform";
    }

    @GetMapping("/student")
    public String getStudent(Model model){
        model.addAttribute("student",studentList);
        return "student";
    }
    @PostMapping("/addstudent")
    public String addStudent(@Valid Student s, BindingResult result)
    {
        boolean status=result.hasErrors();
        if (status)
            return "/studentform";
        studentList.add(s);
        return "redirect:/student";
    }

    @GetMapping("delete/{studentName}")
    public String deleteStudent(@PathVariable(name="studentName") String studentName){
        Student s=null;
        for (Student stud:studentList){
            if (stud.getStudentName().equals(studentName)){
                s=stud;
            }
        }
        studentList.remove(s);
        return "redirect:/student";
    }

    @GetMapping("update/{studentName}")
    public String updateStudent(@PathVariable(name="studentName") String studentName,Model model){
        Student s=null;
        for (Student stud:studentList){
            if (stud.getStudentName().equals(studentName)){
                s=stud;
            }
        }
        model.addAttribute("updatestudent",s);
        return "updatestudent";
    }
    @PostMapping("/updatestudent")
    public String getUpdatedStudent(Student student){
        for (int i=0;i<studentList.size();i++){
            Student s=studentList.get(i);
            if (s.getStudentName().equals(student.getStudentName())){
                studentList.set(i,student);
            }
        }
        return "redirect:/student";
    }

    @GetMapping("/employeeform")
    public String addEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "employeeform";
    }

    @GetMapping("/employee")
    public String getStudInfo(Model model){
        model.addAttribute("employee",employeeList);
        return "/employee";
    }

    @PostMapping("/addemployee")
    public String getEmployee(@Valid Employee e,BindingResult result){
        if (e.getFirstName().equals(e.getLastName()))
            result.rejectValue("lastName","","INVALID LAST NAME");
        boolean status=result.hasErrors();
        if (status)
            return "/employeeform";
            employeeList.add(e);
            return "redirect:/employee";
        }
}
