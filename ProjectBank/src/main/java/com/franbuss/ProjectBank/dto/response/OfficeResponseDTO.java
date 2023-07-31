package com.franbuss.ProjectBank.dto.response;

import javax.validation.constraints.NotBlank;

public class OfficeResponseDTO {

    private String location;

    private String address;

    public OfficeResponseDTO() {
    }

    public OfficeResponseDTO(String location, String address) {
        this.location = location;
        this.address = address;
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
