package com.example.emploee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "emploee")
public class ModelEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String username; //!!!!
    private String password;//!!!!!
    private String email;
    private String phoneNumber;
    private int salary;
    private String position;
   @Enumerated(value = EnumType.STRING)
    private Role role;
    @ManyToOne
    private ModelCompany company;



}
