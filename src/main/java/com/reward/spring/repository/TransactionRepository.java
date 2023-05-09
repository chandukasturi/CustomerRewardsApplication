package com.reward.spring.repository;


import com.reward.spring.entity.Transaction;
import jakarta.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByCustomerId(Long customerId);

    List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from, Timestamp to);
}
