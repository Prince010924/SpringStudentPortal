package com.springapp.StudentPortalSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "student_num" ,nullable = false , length = 8)
    private Long studentNum;

    @Column(name = "address" , nullable = false , length = 50)
    private String address;

    @Column(name = "first_name" , nullable = false , length = 15)
    private String firstName;

    @Column( name = "second_name" , nullable = false , length = 15)
    private String secondName;

    @Column( name = "last_name" , nullable = false , length = 15)
    private String lastName ;

    @Column ( name = "email" , nullable = false , length = 25)
    private String email;

    @Column ( name = "cell_no" , nullable = false , length = 13)
    private String cellNo;
}
