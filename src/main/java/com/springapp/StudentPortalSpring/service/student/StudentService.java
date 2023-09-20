package com.springapp.StudentPortalSpring.service.student;

import com.springapp.StudentPortalSpring.dto.StudentUpdateDto;
import com.springapp.StudentPortalSpring.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student findStudent(String studentNum);

    void updateStudent(StudentUpdateDto studentUpdateDto);
}
