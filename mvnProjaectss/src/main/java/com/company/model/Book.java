package com.company.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {


    private String Title ;
    private String Description ;
    private String Price ;
    private String Count ;

}
