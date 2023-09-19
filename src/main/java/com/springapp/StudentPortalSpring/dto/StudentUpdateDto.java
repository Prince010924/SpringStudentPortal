package com.springapp.StudentPortalSpring.dto;

import com.springapp.StudentPortalSpring.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDto {

    private String address;

    private String firstName;

    private String secondName;

    private String lastName ;

    private String email;

    private String cellNo;

    public StudentUpdateDto mapToStudent(){
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
