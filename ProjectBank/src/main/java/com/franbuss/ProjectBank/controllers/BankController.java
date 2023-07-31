package com.franbuss.ProjectBank.controllers;

import com.franbuss.ProjectBank.dto.request.BankRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.BankResponseDTO;
import com.franbuss.ProjectBank.services.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createBank(@Valid @RequestBody BankRegisterRequestDTO bankRequest) {
        BankResponseDTO createdBank;
        try {
            createdBank = bankService.createBank(bankRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdBank, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable("id") Long id) {
        bankService.deleteBank(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<BankResponseDTO> getAllBanks() {
        return bankService.getAllBanks();
    }


}
