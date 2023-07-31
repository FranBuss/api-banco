package com.franbuss.ProjectBank.services.service;

import com.franbuss.ProjectBank.dto.request.BankRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.BankResponseDTO;

import java.util.List;

public interface BankService {

    //Crear banco
    BankResponseDTO createBank(BankRegisterRequestDTO bankRegisterRequestDTO) throws Exception;

    //Eliminar Banco
    void deleteBank(Long id);

    //Obtener banco
//    BankResponseDTO getBank(Long id);

    //Listar bancos
    List<BankResponseDTO> getAllBanks();


}
