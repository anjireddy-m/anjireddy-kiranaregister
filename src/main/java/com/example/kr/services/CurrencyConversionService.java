package com.example.kr.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.kr.apimodels.CurrencyConversionResponse;

@Service
public class CurrencyConversionService {

    private final String apiUrl = "https://api.fxratesapi.com/latest";

    public CurrencyConversionResponse callCurrencyConversionApi() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, CurrencyConversionResponse.class);
    }

    public BigDecimal convertCurrencyToInr(BigDecimal amount, String currency, CurrencyConversionResponse response) {
        BigDecimal conversionRate = response.getRates().get("INR");
        return amount.multiply(conversionRate);
    }

}
