package com.example.kr.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

/**
 * Represents a financial transaction in the system.
 */
@Entity
public class Transaction {

    /**
     * The unique identifier for the transaction.
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    /**
     * The amount of the transaction.
     */
    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
    private BigDecimal amount;

    /**
     * The currency of the transaction (e.g., INR, USD).
     */
    @NotBlank(message = "Currency cannot be blank")
    @Pattern(regexp = "^(INR|USD)$", message = "Currency must be either INR or USD")
    private String currency;

    /**
     * The timestamp when the transaction occurred.
     */
    private LocalDateTime timestamp;

    /**
     * The name of the customer associated with the transaction.
     */
    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    /**
     * The email of the customer associated with the transaction.
     */
    @NotBlank(message = "Customer email cannot be blank")
    @Email(message = "Invalid email format")
    private String customerEmail;

    /**
     * The card details associated with the transaction.
     */
    @Valid
    @ManyToOne
    @JoinColumn(name = "card_details_id")
    private CardDetails cardDetails;

    /**
     * Default constructor for the Transaction class.
     */
    public Transaction() {
        // Default constructor required by JPA
    }

    /**
     * Parameterized constructor for creating a Transaction object with specified values.
     *
     * @param amount        The amount of the transaction.
     * @param currency      The currency of the transaction (e.g., INR, USD).
     * @param timestamp     The timestamp when the transaction occurred.
     * @param customerName  The name of the customer associated with the transaction.
     * @param customerEmail The email of the customer associated with the transaction.
     */
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
