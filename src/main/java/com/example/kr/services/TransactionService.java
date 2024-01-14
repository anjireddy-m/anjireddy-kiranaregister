package com.example.kr.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.kr.apimodels.CurrencyConversionResponse;
import com.example.kr.apimodels.DailyReportResponse;
import com.example.kr.apimodels.TransactionRequest;
import com.example.kr.db.CardDetailsRepository;
import com.example.kr.db.TransactionRepository;
import com.example.kr.models.CardDetails;
import com.example.kr.models.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardDetailsRepository cardDetailsRepository;
    private final CurrencyConversionService currencyConversionService;


    public TransactionService(TransactionRepository transactionRepository, CardDetailsRepository cardDetailsRepository,
            CurrencyConversionService currencyConversionService) {
        this.transactionRepository = transactionRepository;
        this.cardDetailsRepository = cardDetailsRepository;
        this.currencyConversionService = currencyConversionService;
    }

     /**
     * Records a transaction in the database.
     *
     * @param tRequest The transaction request containing transaction details.
     * @return The recorded transaction.
     */
    @Transactional
    public Transaction recordTransaction(TransactionRequest tRequest) {
        // BigDecimal convertedAmount = convertCurrency(amount, currency);
        CardDetails cardDetails = tRequest.getCardDetails();
        Transaction transaction = new Transaction(tRequest.getAmount(), tRequest.getCurrency(), LocalDateTime.now(),
                tRequest.getCustomerName(), tRequest.getCustomerEmail());
        transaction.setCardDetails(cardDetailsRepository.save(cardDetails));
        return transactionRepository.save(transaction);
    }

    /**
     * Retrieves all transactions from the database.
     *
     * @return List of all transactions.
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    /**
     * Retrieves a daily report for the specified date, including total amounts in INR.
     *
     * @param date The date for which the daily report is generated.
     * @return The daily report response.
     */
    public DailyReportResponse getDailyReport(LocalDate date) {
        List<Transaction> transactions = transactionRepository.findByTimestampBetween(
                date.atStartOfDay(), date.plusDays(1).atStartOfDay().minusSeconds(1));
        Map<String, BigDecimal> totalAmounts = new HashMap<>();
        List<Transaction> transactionsOnDay = new ArrayList<>();

        CurrencyConversionResponse curResponse = currencyConversionService.callCurrencyConversionApi();
        BigDecimal inrConversionRate = curResponse.getRates().get("INR");

        for (Transaction transaction : transactions) {
            BigDecimal amount = transaction.getAmount();
            String currency = transaction.getCurrency();

            // Update total amounts map
            totalAmounts.put(currency, totalAmounts.getOrDefault(currency, BigDecimal.ZERO).add(amount));

            // Perform currency conversion to INR using the API
            if (!currency.equals("INR")) {
                amount = amount.multiply(inrConversionRate);
                totalAmounts.put("GRAND TOTAL (INR)",
                        totalAmounts.getOrDefault("GRAND TOTAL (INR)", BigDecimal.ZERO).add(amount));
            }

            // Add the transaction to the list of transactions on that day
            transactionsOnDay.add(transaction);
        }
        return new DailyReportResponse(transactionsOnDay, totalAmounts, date);
    }
}
