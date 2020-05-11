package com.marbun.api.entitiy;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tenure;
    @Column(nullable = false)
    private BigDecimal ticketSize;
    @Column(nullable = false)
    private BigDecimal fee;
    @Column(nullable = false)
    private BigDecimal totalLoan;
    @Column(nullable = false)
    private BigDecimal installmentPerMonth;
    @Column(nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(BigDecimal totalLoan) {
        this.totalLoan = totalLoan;
    }

    public BigDecimal getInstallmentPerMonth() {
        return installmentPerMonth;
    }

    public void setInstallmentPerMonth(BigDecimal installmentPerMonth) {
        this.installmentPerMonth = installmentPerMonth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", tenure=" + tenure +
                ", ticketSize=" + ticketSize +
                ", fee=" + fee +
                ", totalLoan=" + totalLoan +
                ", installmentPerMonth=" + installmentPerMonth +
                ", status='" + status + '\'' +
                '}';
    }
}
