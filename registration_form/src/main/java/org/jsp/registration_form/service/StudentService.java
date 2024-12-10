package org.jsp.registration_form.service;



import org.jsp.registration_form.dto.Student;
import org.jsp.registration_form.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public String register(Student student, BindingResult result, ModelMap map) {
        
        //to ckeck if password and confirm password are same
        if (!student.getPassword().equals(student.getConfirmPassword()))
            result.rejectValue("confirmPassword", "error.confirmPassword",
                    "Password and Confirm Password does not match");

        //to check if email already exists
        if (repository.existsByEmail(student.getEmail()))
            result.rejectValue("email", "error.email", "Email already exists");
        
        if (result.hasErrors())
            return "register.html";

        //to save student
        else {
            repository.save(student);
            map.put("success", "Registered Successfully");
            return "register.html";
        }
    }
}
