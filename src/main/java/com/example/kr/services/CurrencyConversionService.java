package com.example.kr.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.kr.apimodels.CurrencyConversionResponse;

/**
 * Service class for currency conversion operations.
 */
@Service
public class CurrencyConversionService {

    /**
     * The API URL for fetching the latest currency conversion rates.
     */
    private final String apiUrl = "https://api.fxratesapi.com/latest";

    /**
     * Calls the currency conversion API to retrieve the latest conversion rates.
     *
     * @return The response containing the latest conversion rates.
     */
    public CurrencyConversionResponse callCurrencyConversionApi() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, CurrencyConversionResponse.class);
    }
}
