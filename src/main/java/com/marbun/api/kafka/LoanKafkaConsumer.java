package com.marbun.api.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marbun.api.entitiy.Loan;
import com.marbun.api.repository.LoanRepository;
import com.marbun.api.request.LoanRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanKafkaConsumer {
    private LoanRepository loanRepository;
    private static Logger LOGGER = LoggerFactory.getLogger(LoanKafkaConsumer.class);

    @Autowired
    public LoanKafkaConsumer(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @KafkaListener(topics = "submit-loan")
    public void sendEmail(String loanString , Acknowledgment acknowledgment) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoanRequest loanRequest = objectMapper.readValue(loanString, new TypeReference<LoanRequest>(){});
        try {
            BigDecimal totalFee =  new BigDecimal(loanRequest.getTicketSize().doubleValue()* 2/100);
            BigDecimal totalLoan =  totalFee.add(loanRequest.getTicketSize());
            BigDecimal installment = new BigDecimal(totalLoan.doubleValue()/loanRequest.getTenure());
            Loan loan = new Loan();
            loan.setTenure(loanRequest.getTenure());
            loan.setTicketSize(loanRequest.getTicketSize());
            loan.setFee(totalFee);
            loan.setInstallmentPerMonth(installment);
            loan.setTotalLoan(totalLoan);
            loan.setStatus("SUBMITTED");
            LOGGER.info("LOAN : {}",loan.toString());
            loanRepository.save(loan);
            acknowledgment.acknowledge();
        } catch (Exception e){
            throw e;
        }

    }
}
