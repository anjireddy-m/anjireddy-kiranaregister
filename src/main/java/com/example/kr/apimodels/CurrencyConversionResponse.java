package com.example.kr.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Represents the response from a currency conversion API.
 */
public class CurrencyConversionResponse {
	
	/**
     * Indicates whether the currency conversion was successful.
     */
    private boolean success;

    /**
     * The timestamp of the currency conversion response.
     */
    private long timestamp;

    /**
     * The base currency used for the conversion.
     */
    private String base;

    /**
     * A map containing currency codes as keys and their corresponding conversion rates as values.
     */
    @JsonProperty("rates")
    private Map<String, BigDecimal> rates;

    /**
     * Default constructor for the CurrencyConversionResponse class.
     */
    public CurrencyConversionResponse() {
        // Default constructor
    }

    public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

}
