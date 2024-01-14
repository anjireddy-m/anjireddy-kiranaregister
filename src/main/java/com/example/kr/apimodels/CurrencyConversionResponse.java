package com.example.kr.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConversionResponse {
	
	private boolean success;
    private long timestamp;
    private String base;

    @JsonProperty("rates")
    private Map<String, BigDecimal> rates;

    // Constructors, getters, and setters

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
