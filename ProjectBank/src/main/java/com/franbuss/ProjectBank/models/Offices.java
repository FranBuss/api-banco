package com.franbuss.ProjectBank.models;

import javax.persistence.*;

@Entity
public class Offices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Offices(Long id, String location, Bank bank, String address, User user) {
        this.id = id;
        this.location = location;
        this.bank = bank;
        this.address = address;
        this.user = user;
    }

    public Offices() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
