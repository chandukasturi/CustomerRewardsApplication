package com.reward.spring.service;

import com.reward.spring.entity.Transaction;
import com.reward.spring.exception.CustomerNotFoundException;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactionsByCustomerId(Long customerId);
}
