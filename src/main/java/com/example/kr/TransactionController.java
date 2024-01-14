package com.example.kr;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.example.kr.apimodels.DailyReportResponse;
import com.example.kr.apimodels.TransactionRequest;
import com.example.kr.errors.ValidationErrorResponse;
import com.example.kr.models.Transaction;
import com.example.kr.services.TransactionService;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * Constructor for the TransactionController.
     *
     * @param transactionService The service responsible for handling transaction-related operations.
     */
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Records a new transaction based on the provided transaction request.
     *
     * @param transactionRequest The request containing details for the new transaction.
     * @param bindingResult      The result of the validation process.
     * @return ResponseEntity with the recorded transaction or validation error response.
     */
    @PostMapping
    public ResponseEntity<?> recordTransaction(@Valid @RequestBody TransactionRequest transactionRequest,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Return a response indicating validation errors
            return ResponseEntity.badRequest()
                    .body(new ValidationErrorResponse(HttpStatus.BAD_REQUEST, "Validation errors: " + formatValidationErrors(bindingResult)));
        }

        Transaction recordedTransaction = transactionService.recordTransaction(transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(recordedTransaction);
    }

    /**
     * Retrieves all transactions.
     *
     * @return ResponseEntity with a list of all transactions.
     */
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    /**
     * Retrieves a daily report for the specified date.
     *
     * @param date The date for which the daily report is requested.
     * @return ResponseEntity with the daily report response.
     */
    @GetMapping("/daily-report")
    public ResponseEntity<DailyReportResponse> getDailyReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        DailyReportResponse dailyReport = transactionService.getDailyReport(date);
        return ResponseEntity.ok(dailyReport);
    }

    /**
     * Helper method to format validation errors message.
     *
     * @param bindingResult The result of the validation process.
     * @return Formatted validation errors as a string.
     */
    private String formatValidationErrors(BindingResult bindingResult) {
    // Convert errors to a comma-separated string
    return bindingResult.getAllErrors()
            .stream()
            .map(ObjectError::getDefaultMessage)
            .collect(Collectors.joining(", "));
}
}