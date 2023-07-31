package com.franbuss.ProjectBank.controllers;

import com.franbuss.ProjectBank.dto.request.OfficeRegisterRequestDTO;
import com.franbuss.ProjectBank.dto.response.BankResponseDTO;
import com.franbuss.ProjectBank.dto.response.OfficeResponseDTO;
import com.franbuss.ProjectBank.services.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/office")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService){
        this.officeService = officeService;
    }

    @PostMapping("/registerOffice/bank")
    public ResponseEntity<?> registerOffice(@Valid @RequestBody OfficeRegisterRequestDTO officeRegisterRequestDTO, @RequestParam Long bankId) {
        OfficeResponseDTO createdOffice;
        try {
           createdOffice = officeService.createOffice(bankId, officeRegisterRequestDTO);
        }  catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdOffice, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOffice(@PathVariable("id") Long officeId) {
        officeService.deleteOffice(officeId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
