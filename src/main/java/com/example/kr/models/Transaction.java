package com.example.kr.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
    private BigDecimal amount;

    @NotBlank(message = "Currency cannot be blank")
    @Pattern(regexp = "^(INR|USD)$", message = "Currency must be either INR or USD")
    private String currency;
    private LocalDateTime timestamp;
    
    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    @NotBlank(message = "Customer email cannot be blank")
    @Email(message = "Invalid email format")
    private String customerEmail;
    
    @Valid
    @ManyToOne
    @JoinColumn(name = "card_details_id")
    private CardDetails cardDetails;

    // Constructors, getters, and setters

    public Transaction() {
        // Default constructor required by JPA
    }

    public Transaction(BigDecimal amount, String currency, LocalDateTime timestamp, String customerName,
			String customerEmail) {
		this.amount = amount;
		this.currency = currency;
		this.timestamp = timestamp;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}

	// Getters and Setters...

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

	public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
