package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.dto.request.OfficeRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.OfficeResponseDTO;
import com.franbuss.ProjectBank.models.Bank;
import com.franbuss.ProjectBank.models.Offices;
import com.franbuss.ProjectBank.repositories.BankRepository;
import com.franbuss.ProjectBank.repositories.OfficesRepository;
import com.franbuss.ProjectBank.services.service.OfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final BankRepository bankRepository;
    private final OfficesRepository officesRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public OfficeServiceImpl(BankRepository bankRepository, OfficesRepository officesRepository, ModelMapper modelMapper){
        this.bankRepository = bankRepository;
        this.officesRepository = officesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OfficeResponseDTO createOffice(Long bankId, OfficeRegisterRequestDTO officeRegisterRequestDTO) throws Exception {
        Optional<Bank> optionalBank = bankRepository.findById(bankId);
        Optional<Offices> optionalOffice = officesRepository.findByAddress(officeRegisterRequestDTO.getAddress());

        if(!optionalBank.isPresent()) {
            throw new Exception("Bank not found");
        }
        if (optionalOffice.isPresent()) {
            throw new Exception("The address is already taken");
        }

        Bank bank = optionalBank.get();

        Offices officeMapped = modelMapper.map(officeRegisterRequestDTO, Offices.class);

        officeMapped.setBank(optionalBank.get());
        bank.getOffices().add(officeMapped);

        Offices savedOffice = officesRepository.save(officeMapped);
        return modelMapper.map(savedOffice, OfficeResponseDTO.class);

    }

    @Override
    public void deleteOffice(Long id) {
        officesRepository.deleteById(id);
    }
}
