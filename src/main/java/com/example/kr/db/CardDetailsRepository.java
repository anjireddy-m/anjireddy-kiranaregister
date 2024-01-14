package com.example.kr.db;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kr.models.CardDetails;

/**
 * Repository interface for managing CardDetails entities in the database.
 */
public interface CardDetailsRepository extends JpaRepository<CardDetails, UUID> {

}