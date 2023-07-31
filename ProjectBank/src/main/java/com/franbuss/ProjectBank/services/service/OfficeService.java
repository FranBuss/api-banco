package com.franbuss.ProjectBank.services.service;

import com.franbuss.ProjectBank.dto.request.OfficeRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.OfficeResponseDTO;

public interface OfficeService {

    //Create a new Office
    OfficeResponseDTO createOffice(Long bankId, OfficeRegisterRequestDTO officeRegisterRequestDTO) throws Exception;

    //Delete office
    void deleteOffice(Long id);


}
