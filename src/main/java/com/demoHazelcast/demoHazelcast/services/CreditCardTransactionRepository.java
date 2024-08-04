package com.demoHazelcast.demoHazelcast.services;

import com.demoHazelcast.demoHazelcast.domain.CreditCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Long> {
}
