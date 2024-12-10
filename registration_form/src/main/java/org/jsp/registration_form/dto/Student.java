package org.jsp.registration_form.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

//to generate getters and setters
@Data
//to create a table in database
@Entity
public class Student {
    //to generate id automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; //primary key

    @NotEmpty(message = "Name is required") //to validate the name
    @Size(min = 3,max = 10,message = "Name should be between 3 and 10 characters") 
    private String name;

    //to validate the email
    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    //to validate the password
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;

    @Transient  //transient means it will not be saved in database
    //to validate the confirm password
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String confirmPassword;
}