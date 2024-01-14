package com.example.kr.apimodels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.kr.models.Transaction;

public class DailyReportResponse {

    
    private LocalDate date;
    private Map<String, BigDecimal> totalAmounts;
    private List<Transaction> transactions;
    


    public DailyReportResponse(List<Transaction> transactions, Map<String, BigDecimal> totalAmounts, LocalDate date) {
		super();
		this.transactions = transactions;
		this.totalAmounts = totalAmounts;
		this.date = date;
	}

	// Getters and Setters...

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Map<String, BigDecimal> getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(Map<String, BigDecimal> totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}


