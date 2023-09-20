package com.springapp.StudentPortalSpring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funding_id", referencedColumnName = "id")
    private Funding funding;

    @OneToMany(mappedBy="course" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Course> course;

    @Column(name = "student_num" ,nullable = false , length = 8)
    @NotBlank(message = "Student number is required.")
    private Long studentNum;

    @Column(name = "address" , nullable = false , length = 50)
    @NotBlank(message = "Address is required.")
    private String address;

    @Column(name = "first_name" , nullable = false , length = 15)
    @NotBlank(message = "First name is required.")
    private String firstName;

    @Column( name = "second_name" , nullable = false , length = 15)
    @NotBlank( message = "Second name is required.")
    private String secondName;

    @Column( name = "last_name" , nullable = false , length = 15)
    @NotBlank( message = "Last name is required.")
    private String lastName ;

    @Column ( name = "email" , nullable = false , length = 25)
    @NotBlank(message = "email is required")
    @Email(message = "email is invalid")
    private String email;

    @Column ( name = "cell_no" , nullable = false , length = 13)
    @NotBlank(message = "Cell number is required")
    @Size(min = 10, max = 15, message = "Cell number must be between 10 and 15 characters")
    private String cellNo;

    @Column( name = "password" , nullable = false , length = 128 )
    private String password;

    @OneToMany(mappedBy="modules" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Module> modules;



}
