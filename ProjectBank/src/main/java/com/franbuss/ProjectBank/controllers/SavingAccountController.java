package com.franbuss.ProjectBank.controllers;

import com.franbuss.ProjectBank.dto.request.CashTransferRequestDTO;
import com.franbuss.ProjectBank.dto.request.DepositAndExtractRequestDTO;
import com.franbuss.ProjectBank.dto.request.SavingAccountRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.SavingAccountResponseDTO;
import com.franbuss.ProjectBank.services.service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/saving-account")
public class SavingAccountController {

    private final SavingAccountService savingAccountService;

    @Autowired
    public SavingAccountController(SavingAccountService savingAccountService) {
        this.savingAccountService = savingAccountService;
    }

//    @PostMapping("/saving-account/")
//    public ResponseEntity<?> createSavingAccount(@Valid @RequestBody SavingAccountRegisterRequestDTO savingAccountRegisterRequestDTO) {
//        SavingAccountResponseDTO createdAccount;
//        try {
//            createdAccount = savingAccountService.createSavingAccount(savingAccountRegisterRequestDTO);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/depositMoney")
//    public ResponseEntity<?> depositMoney(@Valid @RequestBody DepositAndExtractRequestDTO depositAndExtractRequestDTO){
//        try {
//            savingAccountService.depositMoney(depositAndExtractRequestDTO);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>("Deposit accepted",HttpStatus.OK);
//    }
//
//    @PutMapping("/extractMoney")
//    public ResponseEntity<?> extractMoney(@Valid @RequestBody DepositAndExtractRequestDTO depositAndExtractRequestDTO) {
//        try {
//            savingAccountService.extractMoney(depositAndExtractRequestDTO);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>("Extract accepted",HttpStatus.OK);
//    }
//
//    @PutMapping("/transferMoney")
//    public ResponseEntity<?> transferMoney(@Valid @RequestBody CashTransferRequestDTO cashTransferRequestDTO){
//        try {
//            savingAccountService.transferMoney(cashTransferRequestDTO);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>("Transfer accepted",HttpStatus.OK);
//    }

}
