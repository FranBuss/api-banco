package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;

public class BankRegisterRequestDTO {

    @NotBlank(message = "Bank name is required")
    private String bankName;


    public BankRegisterRequestDTO(String bankName, String location, String address) {
        this.bankName = bankName;
    }

    public BankRegisterRequestDTO() {
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
