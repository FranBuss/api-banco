package com.franbuss.ProjectBank.models;

import javax.persistence.*;

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    @Column(name = "clave_virtual")
    private String cvu;




}
