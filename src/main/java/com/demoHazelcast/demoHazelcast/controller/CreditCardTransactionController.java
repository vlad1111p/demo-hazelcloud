package com.demoHazelcast.demoHazelcast.controller;

import com.demoHazelcast.demoHazelcast.domain.CreditCardTransaction;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class CreditCardTransactionController {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @GetMapping
    public Collection<CreditCardTransaction> getAllTransactions() {
        Map<String, CreditCardTransaction> transactionMap = hazelcastInstance.getMap("transactions");

        return transactionMap.values();
    }
}