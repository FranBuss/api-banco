package com.franbuss.ProjectBank.dto.response;

public class SavingAccountResponseDTO {

    private String cbu;
    private String location;
    private String address;

    public SavingAccountResponseDTO() {
    }

    public SavingAccountResponseDTO(String cbu, String location, String address) {
        this.cbu = cbu;
        this.location = location;
        this.address = address;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
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
