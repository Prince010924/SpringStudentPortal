package com.springapp.StudentPortalSpring.repository.student;

import com.springapp.StudentPortalSpring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

    Student findByStudentNum(String studentNum);
}
