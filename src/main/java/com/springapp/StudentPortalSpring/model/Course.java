package com.springapp.StudentPortalSpring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "student_id")
    public Student student;

    @Column( name = "name", nullable = false , length = 20)
    @NotBlank(message = "Name of course is required.")
    private String name;

    @Column(name = "cost", nullable = false, length = 10)
    @NotBlank( message = "Cost of course is required.")
    private double cost;


}
