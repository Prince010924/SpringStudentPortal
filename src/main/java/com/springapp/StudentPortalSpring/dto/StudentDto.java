package com.springapp.StudentPortalSpring.dto;

import com.springapp.StudentPortalSpring.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    @NotBlank(message = "Address is required.")
    private String address;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank( message = "Second name is required.")
    private String secondName;

    @NotBlank( message = "Last name is required.")
    private String lastName ;

    @NotBlank(message = "email is required")
    @Email(message = "email is invalid")
    private String email;

    @NotBlank(message = "Cell number is required")
    @Size(min = 10, max = 15, message = "Cell number must be between 10 and 15 characters")
    private String cellNo;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\s:])(\\S){8,128}$", message = "Password must contain at least one lowercase letter, one uppercase letter and one number. It must also contain at least one special character and it must be between 8 and 128 characters")
    private String password;

    public StudentDto mapToStudent(){
        Student student = new Student();
        student.setAddress(this.address);
        student.setFirstName(this.firstName);
        student.setSecondName(this.secondName);
        student.setLastName(this.lastName);
        student.setEmail(this.email);
        student.setCellNo(this.cellNo);
        return this;
    }

}
