package com.example.kr.apimodels;

import java.math.BigDecimal;

import com.example.kr.models.CardDetails;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class TransactionRequest {

    
	@NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
    private BigDecimal amount;

    @NotBlank(message = "Currency cannot be blank")
    @Pattern(regexp = "^(INR|USD)$", message = "Currency must be either INR or USD")
    private String currency;

    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    @NotBlank(message = "Customer email cannot be blank")
    @Email(message = "Invalid email format")
    private String customerEmail;

    @Valid
    private CardDetails cardDetails;

    // Constructors, getters, and setters...
    
    
	public TransactionRequest(BigDecimal amount, String currency, String customerName, String customerEmail,
			CardDetails cardDetails) {
		super();
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

