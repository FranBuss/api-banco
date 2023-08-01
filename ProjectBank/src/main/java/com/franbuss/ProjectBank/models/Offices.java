package com.franbuss.ProjectBank.models;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<User> users;

    public Offices(Long id, String location, Bank bank, String address, List<User> users) {
        this.id = id;
        this.location = location;
        this.bank = bank;
        this.address = address;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
