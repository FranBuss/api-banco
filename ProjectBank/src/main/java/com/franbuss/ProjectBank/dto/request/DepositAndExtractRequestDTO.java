package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class DepositAndExtractRequestDTO {

    @NotBlank
    private String dni;

    private BigDecimal amount;

    public DepositAndExtractRequestDTO() {
    }

    public DepositAndExtractRequestDTO(String dni, BigDecimal amount) {
        this.dni = dni;
        this.amount = amount;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
