package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class CashTransferRequestDTO {
    
    private BigDecimal amount;

    @NotBlank
    private String cbuUser;

    @NotBlank
    private String cbuToUser;

    public CashTransferRequestDTO() {
    }

    public CashTransferRequestDTO(BigDecimal amount, String cbuUser, String cbuToUser) {
        this.amount = amount;
        this.cbuUser = cbuUser;
        this.cbuToUser = cbuToUser;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
}
