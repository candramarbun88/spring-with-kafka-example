package com.marbun.api.request;

import java.math.BigDecimal;

public class LoanRequest {
    private int tenure;
    private BigDecimal ticketSize;

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public BigDecimal getTicketSize() {
        return ticketSize;
    }

    public void setTicketSize(BigDecimal ticketSize) {
        this.ticketSize = ticketSize;
    }
}
