package com.marbun.api.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marbun.api.kafka.LoanKafkaConsumer;
import com.marbun.api.request.LoanRequest;
import com.marbun.api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    private KafkaTemplate kafkaTemplate;

    @Autowired
    public LoanServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void submmitLoan(LoanRequest loanRequest) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            kafkaTemplate.send("submit-loan",mapper.writeValueAsString(loanRequest));
        } catch (Exception ex){
            try {
                throw ex;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}
