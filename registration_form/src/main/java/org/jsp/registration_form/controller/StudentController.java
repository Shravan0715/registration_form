package org.jsp.registration_form.controller;

import org.jsp.registration_form.dto.Student;
import org.jsp.registration_form.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class StudentController {

    @Autowired
    StudentService service;

    //to show the form
    @GetMapping("/")
    public String showForm(ModelMap map,Student student) {
        map.put("student", student);
        return "register.html";
    }
    //to register the student
    @PostMapping("/register")
    public String register(Student student, BindingResult result,ModelMap map) {
        
        return service.register(student,result, map) ;
    }
    
    
}
