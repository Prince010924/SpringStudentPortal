package com.springapp.StudentPortalSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "results")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_semester_mark" , nullable = false )
    private Long firstSemesterMark;

    @Column(name = "first_pass" , nullable = false)
    private boolean firstPass;

    @Column(name = "second_semester_mark" , nullable = false)
    private Long secondSemesterMark;

    @Column(name = "second_pass" , nullable = false)
    private boolean secondPass;
}
