package com.reward.spring.repository;
import com.reward.spring.entity.Transaction;
import com.reward.spring.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.List;

@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testFindAllByCustomerId() {
        Transaction t1 = new Transaction();
        t1.setCustomerId(1L);
        t1.setTransactionAmount(10.0);
        t1.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        transactionRepository.save(t1);

        Transaction t2 = new Transaction();
        t2.setCustomerId(1L);
        t2.setTransactionAmount(20.0);
        t2.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        transactionRepository.save(t2);

        Transaction t3 = new Transaction();
        t3.setCustomerId(2L);
        t3.setTransactionAmount(30.0);
        t3.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        transactionRepository.save(t3);

        List<Transaction> customer1Transactions = transactionRepository.findAllByCustomerId(1L);
        Assertions.assertEquals(2, customer1Transactions.size());
        Assertions.assertTrue(customer1Transactions.contains(t1));
        Assertions.assertTrue(customer1Transactions.contains(t2));

        List<Transaction> customer2Transactions = transactionRepository.findAllByCustomerId(2L);
        Assertions.assertEquals(1, customer2Transactions.size());
        Assertions.assertTrue(customer2Transactions.contains(t3));
    }

    @Test
    public void testFindAllByCustomerIdAndTransactionDateBetween() {
        Transaction t1 = new Transaction();
        t1.setCustomerId(1L);
        t1.setTransactionAmount(10.0);
        t1.setTransactionDate(Timestamp.valueOf("2022-05-01 12:00:00"));
        transactionRepository.save(t1);

        Transaction t2 = new Transaction();
        t2.setCustomerId(1L);
        t2.setTransactionAmount(20.0);
        t2.setTransactionDate(Timestamp.valueOf("2022-05-02 12:00:00"));
        transactionRepository.save(t2);

        Transaction t3 = new Transaction();
        t3.setCustomerId(1L);
        t3.setTransactionAmount(30.0);
        t3.setTransactionDate(Timestamp.valueOf("2022-05-03 12:00:00"));
        transactionRepository.save(t3);

        List<Transaction> customer1Transactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(1L,
                Timestamp.valueOf("2022-05-01 00:00:00"), Timestamp.valueOf("2022-05-02 23:59:59"));
        Assertions.assertEquals(2, customer1Transactions.size());
        Assertions.assertTrue(customer1Transactions.contains(t1));
        Assertions.assertTrue(customer1Transactions.contains(t2));

        List<Transaction> customer1Transactions2 = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(1L,
                Timestamp.valueOf("2022-05-02 00:00:00"), Timestamp.valueOf("2022-05-03 23:59:59"));
        Assertions.assertEquals(2, customer1Transactions2.size());
        Assertions.assertTrue(customer1Transactions2.contains(t2));
        Assertions.assertTrue(customer1Transactions2.contains(t3));
    }
}

