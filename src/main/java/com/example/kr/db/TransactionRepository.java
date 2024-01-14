package com.example.kr.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.kr.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

	List<Transaction> findByTimestampBetween(LocalDateTime atStartOfDay, LocalDateTime minusSeconds);

}