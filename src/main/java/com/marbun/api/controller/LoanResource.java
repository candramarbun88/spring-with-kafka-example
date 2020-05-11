package com.marbun.api.controller;

import com.marbun.api.request.LoanRequest;
import com.marbun.api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoanResource {
    private LoanService loanService;

    @Autowired
    public LoanResource(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/api/submit")
    public ResponseEntity submitData(@RequestBody LoanRequest loanRequest){
        Map<String,String> resp = new HashMap<>();
        try {
            loanService.submmitLoan(loanRequest);
        }catch (Exception ex){
            resp.put("message",ex.getLocalizedMessage());
             return ResponseEntity.status(400).body(ex.getLocalizedMessage());
        }
        resp.put("message","sukses submit data");
        return ResponseEntity.ok(resp);
    }
}
