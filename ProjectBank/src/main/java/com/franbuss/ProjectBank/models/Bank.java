package com.franbuss.ProjectBank.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    private List<Offices> offices;

    private String bankName;


    public Bank() {
    }

    public Bank(Long id, List<Offices> offices, String bankName) {
        this.id = id;
        this.offices = offices;
        this.bankName = bankName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Offices> getOffices() {
        return offices;
    }

    public void setOffices(List<Offices> offices) {
        this.offices = offices;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
