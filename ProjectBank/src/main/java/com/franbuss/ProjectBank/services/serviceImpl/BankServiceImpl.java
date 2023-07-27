package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.dto.request.BankRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.request.BankUpdateRequestDTO;
import com.franbuss.ProjectBank.dto.response.BankResponseDTO;
import com.franbuss.ProjectBank.models.Bank;
import com.franbuss.ProjectBank.repositories.BankRepository;
import com.franbuss.ProjectBank.services.service.BankService;

import java.util.Optional;

public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    @Override
    public BankResponseDTO createBank(BankRegisterRequestDTO bankRegisterRequestDTO) {
//        Optional<Bank> bank = bankRepository.findByUser();
        return null;
    }

    @Override
    public BankResponseDTO updateBank(Long id, BankUpdateRequestDTO bankUpdateRequestDTO) {
        return null;
    }

    @Override
    public void deleteBank(Long id) {

    }
}
