package com.franbuss.ProjectBank.dto.request;

import javax.validation.constraints.NotBlank;

public class OfficeRegisterRequestDTO {

    @NotBlank(message = "Bank location is required")

    private String location;

    @NotBlank(message = "Address is required")
    private String address;

    public OfficeRegisterRequestDTO(String location, String address) {
        this.location = location;
        this.address = address;
    }

    public OfficeRegisterRequestDTO() {
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
