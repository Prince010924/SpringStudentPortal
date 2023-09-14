package com.springapp.StudentPortalSpring.repository.lecturer;

import com.springapp.StudentPortalSpring.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
}