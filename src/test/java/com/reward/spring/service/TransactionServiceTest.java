package com.reward.spring.service;

import com.reward.spring.entity.Transaction;
import com.reward.spring.exception.CustomerNotFoundException;
import com.reward.spring.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionService(transactionRepository);
    }

    @Test
    void testGetTransactionsByCustomerId() throws CustomerNotFoundException {
        Long customerId = 1L;
        Timestamp transactionDate = new Timestamp(System.currentTimeMillis());

        Transaction transaction1 = new Transaction();
        transaction1.setCustomerId(customerId);
        transaction1.setTransactionAmount(10.0);
        transaction1.setTransactionDate(transactionDate);

        Transaction transaction2 = new Transaction();
        transaction2.setCustomerId(customerId);
        transaction2.setTransactionAmount(20.0);
        transaction2.setTransactionDate(transactionDate);

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2);

        when(transactionRepository.findByCustomerId(customerId)).thenReturn(transactions);

        List<Transaction> actualTransactions = transactionService.getTransactionsByCustomerId(customerId);

        Assertions.assertEquals(transactions, actualTransactions);
    }

}
