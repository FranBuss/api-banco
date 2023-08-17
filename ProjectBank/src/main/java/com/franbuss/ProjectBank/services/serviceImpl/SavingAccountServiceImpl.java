package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.dto.request.CashTransferRequestDTO;
import com.franbuss.ProjectBank.dto.request.DepositAndExtractRequestDTO;
import com.franbuss.ProjectBank.dto.request.SavingAccountRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.SavingAccountResponseDTO;
import com.franbuss.ProjectBank.models.Offices;
import com.franbuss.ProjectBank.models.SavingsAccount;
import com.franbuss.ProjectBank.models.User;
import com.franbuss.ProjectBank.repositories.OfficesRepository;
import com.franbuss.ProjectBank.repositories.SavingAccountRepository;
import com.franbuss.ProjectBank.repositories.UserRepository;
import com.franbuss.ProjectBank.services.service.SavingAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SavingAccountServiceImpl implements SavingAccountService {

    private final UserRepository userRepository;
    private final SavingAccountRepository savingAccountRepository;
    private final OfficesRepository officesRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public SavingAccountServiceImpl(UserRepository userRepository, SavingAccountRepository savingAccountRepository, OfficesRepository officesRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.savingAccountRepository = savingAccountRepository;
        this.officesRepository = officesRepository;
        this.modelMapper = modelMapper;
    }

//    @Override
//    public SavingAccountResponseDTO createSavingAccount(SavingAccountRegisterRequestDTO savingAccountRegisterRequestDTO) throws Exception {
//        Optional<User> user = userRepository.findByDni(savingAccountRegisterRequestDTO.getDni());
//
//        String optionalCbu = cbuGenerator();
//
//        Optional<SavingsAccount> optionalSavingsAccount = savingAccountRepository.findByCbu(optionalCbu);
//
//        Optional<Offices> optionalOffices = officesRepository.findById(savingAccountRegisterRequestDTO.getOffice_id());
//
//        if (user.isPresent() && !optionalSavingsAccount.isPresent() && optionalOffices.isPresent()) {
//            SavingsAccount savingAccount = new SavingsAccount();
//
//            Offices office = optionalOffices.get();
//
//            savingAccount.setCbu(optionalCbu);
//            savingAccount.setUser(user.get());
//            savingAccount.setAmount(BigDecimal.ZERO);
//
//            office.getUsers().add(savingAccount.getUser());
//
//            officesRepository.save(office);
//            savingAccountRepository.save(savingAccount);
//
//            return new SavingAccountResponseDTO(savingAccount.getCbu(), office.getLocation(), office.getAddress());
//        } else {
//            throw new Exception("Could not find saving account or user");
//        }
//    }

//    @Override
//    public void depositMoney(DepositAndExtractRequestDTO depositAndExtractRequestDTO) throws Exception {
//        Optional<User> optionalUser = userRepository.findByDni(depositAndExtractRequestDTO.getDni());
//        if (optionalUser.isPresent()) {
//            Optional<SavingsAccount> optionalSavingsAccount = savingAccountRepository.findByUser(optionalUser.get());
//            if (optionalSavingsAccount.isPresent()) {
//
//                SavingsAccount savingsAccount = optionalSavingsAccount.get();
//                BigDecimal amountToDeposit = depositAndExtractRequestDTO.getAmount();
//
//                if (amountToDeposit.compareTo(BigDecimal.ZERO) >= 0){
//                    savingsAccount.setAmount(savingsAccount.getAmount().add(depositAndExtractRequestDTO.getAmount()));
//                } else {
//                    throw new Exception("The amount to deposit cannot be negative");
//                }
//
//                savingAccountRepository.save(savingsAccount);
//            }
//        }
//    }
//
//    @Override
//    public void extractMoney(DepositAndExtractRequestDTO depositAndExtractRequestDTO) throws Exception {
//        Optional<User> optionalUser = userRepository.findByDni(depositAndExtractRequestDTO.getDni());
//        if (optionalUser.isPresent()) {
//            Optional<SavingsAccount> optionalSavingsAccount = savingAccountRepository.findByUser(optionalUser.get());
//            if (optionalSavingsAccount.isPresent()) {
//                SavingsAccount savingsAccount = optionalSavingsAccount.get();
//
//                BigDecimal amountToWithdraw = depositAndExtractRequestDTO.getAmount();
//
//                if (amountToWithdraw.compareTo(BigDecimal.ZERO) <= 0) {
//                    throw new Exception("Invalid amount");
//                }
//                if (amountToWithdraw.compareTo(savingsAccount.getAmount()) > 0) {
//                    throw new Exception("Invalid amount");
//                }
//
//                savingsAccount.setAmount(savingsAccount.getAmount().subtract(amountToWithdraw));
//                savingAccountRepository.save(savingsAccount);
//            }
//        }
//    }

//    public void transferMoney(CashTransferRequestDTO cashTransferRequestDTO) throws Exception {
//        Optional<SavingsAccount> userSavingAccount = savingAccountRepository.findByCbu(cashTransferRequestDTO.getCbuUser());
//        Optional<SavingsAccount> toUserSavingAccount = savingAccountRepository.findByCbu(cashTransferRequestDTO.getCbuToUser());
//
//        if (userSavingAccount.isPresent() && toUserSavingAccount.isPresent()) {
//            SavingsAccount user = userSavingAccount.get();
//            SavingsAccount toUser = toUserSavingAccount.get();
//
//            BigDecimal amountToTransfer = cashTransferRequestDTO.getAmount();
//
//            if (amountToTransfer.compareTo(BigDecimal.ZERO) >= 0) {
//                user.setAmount(user.getAmount().subtract(amountToTransfer));
//                toUser.setAmount(toUser.getAmount().add(amountToTransfer));
//
//                savingAccountRepository.save(user);
//                savingAccountRepository.save(toUser);
//            } else {
//                throw new Exception("Invalid amount");
//            }
//
//        }
//
//    }
//
//    @Override
//    public String cbuGenerator() {
//        int cbuLength = 22;
//        StringBuilder cbuBuilder = new StringBuilder(cbuLength);
//
//        ThreadLocalRandom.current().ints(cbuLength, 0, 10)
//                .forEach(cbuBuilder::append);
//
//        return cbuBuilder.toString();
//    }
}
