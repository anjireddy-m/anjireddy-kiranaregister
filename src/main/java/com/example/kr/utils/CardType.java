package com.example.kr.utils;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CardType {
    CREDIT,
    DEBIT;
    
    @JsonCreator
    public static CardType fromString(String value) {
        try {
            return CardType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid card type: " + value);
        }
    }
}