package com.example.kr.models;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.example.kr.utils.CardType;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;;

/**
 * Represents the details of a credit/debit card in the system.
 */
@Entity
public class CardDetails {

	/**
     * The unique identifier for the card.
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

	/**
     * The name associated with the card.
     */
	@NotBlank(message = "Name cannot be blank")
    private String name;

	/**
     * The expiration date of the card in the format MM/YY.
     */
	@NotBlank(message = "Expiration date cannot be blank")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/(\\d{2})$", message = "Expiration date must be in the format MM/YY")
    private String expDate;

	/**
     * The last four digits of the card number.
     */
	@NotBlank(message = "Last four digits cannot be blank")
    @Size(min = 4, max = 4, message = "Last four digits must be exactly 4 characters")
    private String lastFourDigits;

	/**
     * The type of the card (e.g., CREDIT, DEBIT).
     */
    @Valid
    private CardType cardType;

	/**
     * Default constructor for the CardDetails class.
     */
	public CardDetails()  {

	}

	/**
     * Parameterized constructor for creating a CardDetails object with specified values.
     *
     * @param name           The name associated with the card.
     * @param expDate        The expiration date of the card in the format MM/YY.
     * @param lastFourDigits The last four digits of the card number.
     * @param cardType       The type of the card (e.g., CREDIT, DEBIT).
     */
    public CardDetails(String name, String expDate, String lastFourDigits, CardType cardType) {
    	super();
    	this.name = name;
    	this.expDate = expDate;
    	this.lastFourDigits = lastFourDigits;
    	this.cardType = cardType;
    }
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getLastFourDigits() {
		return lastFourDigits;
	}
	public void setLastFourDigits(String lastFourDigits) {
		this.lastFourDigits = lastFourDigits;
	}
	public CardType getCardType() {
		return cardType;
	}
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
}