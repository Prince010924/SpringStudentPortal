package com.springapp.StudentPortalSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lecturer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false , length = 15)
    private String firstName;

    @Column(name = "second_name" , nullable = false , length = 15)
    private String secondName;

    @Column(name = "last_name" , nullable = false , length = 15)
    private String lastName;

    @Column(name = "email" , nullable = false , length = 50)
    private String email;
}
