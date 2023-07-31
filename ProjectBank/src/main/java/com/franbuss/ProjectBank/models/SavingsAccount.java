package com.franbuss.ProjectBank.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private String cbu;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SavingsAccount() {
    }

    public SavingsAccount(Long id, BigDecimal amount, String cbu, User user) {
        this.id = id;
        this.amount = amount;
        this.cbu = cbu;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
