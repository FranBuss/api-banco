package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;

public class CashTransferRequestDTO {

    @NotBlank
    private Float amount;

    @NotBlank
    private String cbu;



}
