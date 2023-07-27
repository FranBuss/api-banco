package com.franbuss.ProjectBank.services.service;

import com.franbuss.ProjectBank.dto.request.BankRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.BankUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.BankResponseDTO;

public interface BankService {

    //Crear banco
    BankResponseDTO createBank(BankRegisterRequestDTO bankRegisterRequestDTO);

    //Modificar Banco
    BankResponseDTO updateBank(Long id, BankUpdateRequestDTO bankUpdateRequestDTO);

    //Eliminar Banco
    void deleteBank(Long id);

    //Obtener banco
//    BankResponseDTO getBank(Long id);

}
