package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;

public class SavingAccountRegisterRequestDTO {

    @NotBlank(message = "Please enter a correct dni")
    private String dni;
//    @NotBlank(message = "Please enter an office id")
    private Long office_id;

    public SavingAccountRegisterRequestDTO() {
    }

    public SavingAccountRegisterRequestDTO(String dni, Long office_id) {
        this.dni = dni;
        this.office_id = office_id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Long office_id) {
        this.office_id = office_id;
    }
}
