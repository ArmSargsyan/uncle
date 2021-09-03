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
@Table(name = "massage")
public class MassageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sms;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private ModelEmployee fromEmployee;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private ModelEmployee toEmployee;

}
