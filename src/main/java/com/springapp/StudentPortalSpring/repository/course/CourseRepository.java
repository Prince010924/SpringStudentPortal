package com.springapp.StudentPortalSpring.repository.course;

import com.springapp.StudentPortalSpring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
