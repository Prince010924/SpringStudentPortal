package com.springapp.StudentPortalSpring.service.student;

import com.springapp.StudentPortalSpring.dto.StudentUpdateDto;
import com.springapp.StudentPortalSpring.model.Student;
import com.springapp.StudentPortalSpring.repository.student.StudentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    final private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student findStudent(String studentNum) {
        Student student = studentRepository.findByStudentNum(studentNum);
        return student;
    }

  public void updateStudent(StudentUpdateDto studentUpdateDto){
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String studentNum = authentication.getName();
      Student studentToUpdate = findStudent(studentNum);
      if(studentToUpdate != null){
          StudentUpdateDto student = studentUpdateDto.mapToStudent();
          Student studentUpdated = studentToUpdate;
          studentUpdated.setFirstName(student.getFirstName());
          studentUpdated.setSecondName(student.getSecondName());
          studentUpdated.setAddress(student.getAddress());
          studentUpdated.setCellNo(student.getCellNo());
          studentRepository.save(studentUpdated);
      }

   }

}
