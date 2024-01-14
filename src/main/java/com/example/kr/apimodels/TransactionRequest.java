package com.example.kr.apimodels;

import java.math.BigDecimal;

import com.example.kr.models.CardDetails;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Represents a request for recording a financial transaction.
 */
public class TransactionRequest {
    
	/**
     * The amount of the transaction.
     */
    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
    private BigDecimal amount;

    /**
     * The currency code for the transaction (e.g., INR, USD).
     */
    @NotBlank(message = "Currency cannot be blank")
    @Pattern(regexp = "^(INR|USD)$", message = "Currency must be either INR or USD")
    private String currency;

    /**
     * The name of the customer initiating the transaction.
     */
    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    /**
     * The email of the customer initiating the transaction.
     */
    @NotBlank(message = "Customer email cannot be blank")
    @Email(message = "Invalid email format")
    private String customerEmail;

    /**
     * The details of the card used for the transaction.
     */
    @Valid
    private CardDetails cardDetails;

    /**
     * Constructor for creating a TransactionRequest object with specified values.
     *
     * @param amount        The amount of the transaction.
     * @param currency      The currency code for the transaction.
     * @param customerName  The name of the customer initiating the transaction.
     * @param customerEmail The email of the customer initiating the transaction.
     * @param cardDetails   The details of the card used for the transaction.
     */
    public TransactionRequest(BigDecimal amount, String currency, String customerName, String customerEmail,
                               CardDetails cardDetails) {
        this.amount = amount;
        this.currency = currency;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.cardDetails = cardDetails;
    }


	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
}

