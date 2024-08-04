package com.demoHazelcast.demoHazelcast.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class CreditCardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionID;
    private LocalDateTime transactionDate;
    private Double amount;
    private String cardType;
    private String cardNumber;
    private String merchant;
    private String merchantCity;
    private String merchantState;
    private String merchantZipCode;
    private String country;
    private Boolean fraud;
}