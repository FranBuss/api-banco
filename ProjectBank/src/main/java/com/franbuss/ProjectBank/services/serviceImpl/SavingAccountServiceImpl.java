package com.franbuss.ProjectBank.services.serviceImpl;

import com.franbuss.ProjectBank.services.service.SavingAccountService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SavingAccountServiceImpl implements SavingAccountService {

    @Override
    public String cbuGenerator() {
        int cbuLength = 22;
        StringBuilder cbuBuilder = new StringBuilder(cbuLength);

        ThreadLocalRandom.current().ints(cbuLength, 0, 10)
                .forEach(cbuBuilder::append);

        return cbuBuilder.toString();
    }
}
