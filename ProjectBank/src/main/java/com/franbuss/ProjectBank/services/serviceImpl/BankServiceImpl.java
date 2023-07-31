package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.dto.request.BankRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.BankResponseDTO;
import com.franbuss.ProjectBank.dto.response.UserResponseDTO;
import com.franbuss.ProjectBank.models.Bank;
import com.franbuss.ProjectBank.models.User;
import com.franbuss.ProjectBank.repositories.BankRepository;
import com.franbuss.ProjectBank.repositories.UserRepository;
import com.franbuss.ProjectBank.services.service.BankService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public BankServiceImpl(BankRepository bankRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public BankResponseDTO createBank(BankRegisterRequestDTO bankRegisterRequestDTO) throws Exception {

        Optional<Bank> optionalBank = bankRepository.findByBankName(bankRegisterRequestDTO.getBankName());

        if (optionalBank.isPresent()) {
            throw new Exception("Bank is already registered");
        }

        Bank bankMapped = modelMapper.map(bankRegisterRequestDTO, Bank.class);
        Bank savedBank = bankRepository.save(bankMapped);
        return modelMapper.map(savedBank, BankResponseDTO.class);
    }


    @Override
    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }


    @Override
    public List<BankResponseDTO> getAllBanks() {
        List<Bank> bankList = bankRepository.findAll();
        return bankList.stream()
                .map(bank -> modelMapper.map(bank, BankResponseDTO.class))
                .collect(Collectors.toList());
    }
}
