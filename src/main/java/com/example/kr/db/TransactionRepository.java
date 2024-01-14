package com.example.kr.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.kr.models.Transaction;

/**
 * Repository interface for managing Transaction entities in the database.
 */
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

	/**
     * Retrieves a list of transactions with timestamps between the specified start and end times.
     *
     * @param startTime The start time (inclusive) to filter transactions.
     * @param endTime   The end time (exclusive) to filter transactions.
     * @return A list of transactions within the specified time range.
     */
	List<Transaction> findByTimestampBetween(LocalDateTime atStartOfDay, LocalDateTime minusSeconds);

}