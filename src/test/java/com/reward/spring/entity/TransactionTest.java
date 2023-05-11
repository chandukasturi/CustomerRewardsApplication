package com.reward.spring.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {

    @Test
    void testGettersAndSetters() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1001L);
        transaction.setCustomerId(101L);
        transaction.setTransactionAmount(200.0);
        Timestamp timestamp = Timestamp.valueOf("2023-04-10 11:20:43");
        transaction.setTransactionDate(timestamp);

        assertThat(transaction.getTransactionId()).isEqualTo(1001L);
        assertThat(transaction.getCustomerId()).isEqualTo(101L);
        assertThat(transaction.getTransactionAmount()).isEqualTo(200.0);
        assertThat(transaction.getTransactionDate()).isEqualTo(timestamp);
    }

    @Test
    void testEqualsAndHashCode() {
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionId(1L);
        transaction1.setCustomerId(2L);
        transaction1.setTransactionAmount(100.0);
        Timestamp timestamp1 = Timestamp.valueOf("2023-05-11 12:30:45");
        transaction1.setTransactionDate(timestamp1);

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionId(1L);
        transaction2.setCustomerId(2L);
        transaction2.setTransactionAmount(100.0);
        Timestamp timestamp2 = Timestamp.valueOf("2023-05-11 12:30:45");
        transaction2.setTransactionDate(timestamp2);

        assertThat(transaction1).isEqualTo(transaction2);
        assertThat(transaction1.hashCode()).isEqualTo(transaction2.hashCode());
    }

}
