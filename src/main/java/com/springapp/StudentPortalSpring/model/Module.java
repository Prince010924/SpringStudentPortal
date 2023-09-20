package com.springapp.StudentPortalSpring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "modules")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @Column(name = "name" , nullable = false , length = 20)
    @NotBlank(message = "Name of modules required.")
    private String name;

    @Column(name = "module_code" , nullable = false , length = 6)
    private String moduleCode;
}
