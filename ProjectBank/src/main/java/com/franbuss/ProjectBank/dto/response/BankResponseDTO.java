package com.franbuss.ProjectBank.dto.response;

public class BankResponseDTO {

    private String bankName;


    public BankResponseDTO() {
    }

    public BankResponseDTO(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
