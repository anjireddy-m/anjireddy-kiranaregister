package com.example.kr;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.kr.apimodels.DailyReportResponse;
import com.example.kr.apimodels.TransactionRequest;
import com.example.kr.errors.ValidationErrorResponse;
import com.example.kr.models.Transaction;
import com.example.kr.services.TransactionService;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<?> recordTransaction(@RequestBody @Valid TransactionRequest transactionRequest,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Return a response indicating validation errors
        	return ResponseEntity.badRequest().body(new ValidationErrorResponse(HttpStatus.BAD_REQUEST, "Validation errors: " + bindingResult.getAllErrors()));
        }

        Transaction recordedTransaction = transactionService.recordTransaction(transactionRequest);
        return ResponseEntity.ok(recordedTransaction);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/daily-report")
    public ResponseEntity<DailyReportResponse> getDailyReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        DailyReportResponse dailyReport = transactionService.getDailyReport(date);
        return ResponseEntity.ok(dailyReport);
    }

}