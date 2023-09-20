package com.springapp.StudentPortalSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "funding")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "name" , nullable = false , length = 20)
    @NotBlank(message = "Name of funding is required.")
    private String name;

    @Column( name = "balance" , nullable = false , length = 10)
    @NotBlank(message = "Balance sent for funding is required.")
    private Double balance;

    @OneToOne(mappedBy = "student" )
    private Student student;
}
