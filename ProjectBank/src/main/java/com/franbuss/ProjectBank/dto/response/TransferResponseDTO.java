package com.franbuss.ProjectBank.dto.response;

import java.math.BigDecimal;

public class TransferResponseDTO {

    private String cbuUser;

    private String cbuToUser;

    private BigDecimal amount;

    public TransferResponseDTO() {
    }

    public TransferResponseDTO(String cbuUser, String cbuToUser, BigDecimal amount) {
        this.cbuUser = cbuUser;
        this.cbuToUser = cbuToUser;
        this.amount = amount;
    }

    public String getCbuUser() {
        return cbuUser;
    }

    public void setCbuUser(String cbuUser) {
        this.cbuUser = cbuUser;
    }

    public String getCbuToUser() {
        return cbuToUser;
    }

    public void setCbuToUser(String cbuToUser) {
        this.cbuToUser = cbuToUser;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
