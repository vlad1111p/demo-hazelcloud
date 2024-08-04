package com.demoHazelcast.demoHazelcast.services;

import com.demoHazelcast.demoHazelcast.domain.CreditCardTransaction;
import com.hazelcast.core.HazelcastInstance;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class CreditCardTransactionService {

    @Autowired
    private CreditCardTransactionRepository repository;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void importCSVData() {
        String fileName = "csv/credit_card_transactions.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            String[] values = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

            Map<String, CreditCardTransaction> transactionMap = new HashMap<>();

            while ((values = csvReader.readNext()) != null) {
                CreditCardTransaction transaction = CreditCardTransaction.builder()
                        .transactionID(values[0])
                        .transactionDate(LocalDateTime.parse(values[1], formatter))
                        .amount(Double.parseDouble(values[2]))
                        .cardType(values[3])
                        .cardNumber(values[4])
                        .merchant(values[5])
                        .merchantCity(values[6])
                        .merchantState(values[7])
                        .merchantZipCode(values[8])
                        .country(values[9])
                        .fraud(Boolean.parseBoolean(values[10]))
                        .build();

                repository.save(transaction);
                transactionMap.put(transaction.getTransactionID(), transaction);
            }

            hazelcastInstance.getMap("transactions").putAll(transactionMap);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
