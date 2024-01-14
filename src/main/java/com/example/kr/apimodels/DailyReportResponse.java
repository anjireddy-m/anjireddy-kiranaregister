package com.example.kr.apimodels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.kr.models.Transaction;

/**
 * Represents the response containing daily transaction details and total amounts.
 */
public class DailyReportResponse {

    /**
     * The date for which the daily report is generated.
     */
    private LocalDate date;

    /**
     * A map containing currency codes as keys and their corresponding total amounts as values.
     */
    private Map<String, BigDecimal> totalAmounts;

    /**
     * The list of transactions that occurred on the specified date.
     */
    private List<Transaction> transactions;

    /**
     * Constructor for creating a DailyReportResponse object with specified values.
     *
     * @param transactions The list of transactions.
     * @param totalAmounts A map containing currency codes and their corresponding total amounts.
     * @param date         The date for which the daily report is generated.
     */
    public DailyReportResponse(List<Transaction> transactions, Map<String, BigDecimal> totalAmounts, LocalDate date) {
        this.transactions = transactions;
        this.totalAmounts = totalAmounts;
        this.date = date;
    }


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
