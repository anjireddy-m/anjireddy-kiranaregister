package com.example.kr.db;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kr.models.CardDetails;

public interface CardDetailsRepository extends JpaRepository<CardDetails, UUID> {

}