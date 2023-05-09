package com.reward.spring.service;

import com.reward.spring.entity.Transaction;
import com.reward.spring.model.Rewards;
import com.reward.spring.repository.TransactionRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RewardsServiceImplTest {
    @InjectMocks
    RewardsServiceImpl rewardsService;
    @Mock
    TransactionRepository transactionRepository;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;

    public RewardsServiceImplTest() {
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.transaction1 = new Transaction();
        this.transaction1.setCustomerId(1L);
        this.transaction1.setTransactionAmount(25.0);
        this.transaction1.setTransactionDate(Timestamp.from(Instant.now()));
        this.transaction2 = new Transaction();
        this.transaction2.setCustomerId(1L);
        this.transaction2.setTransactionAmount(75.0);
        this.transaction2.setTransactionDate(Timestamp.from(Instant.now()));
        this.transaction3 = new Transaction();
        this.transaction3.setCustomerId(1L);
        this.transaction3.setTransactionAmount(125.0);
        this.transaction3.setTransactionDate(Timestamp.from(Instant.now()));
    }

    @Test
    public void testGetRewardsByCustomerId() {
        List<Transaction> firstMonthTransactions = new ArrayList();
        firstMonthTransactions.add(this.transaction1);
        firstMonthTransactions.add(this.transaction2);
        List<Transaction> secondMonthTransactions = new ArrayList();
        secondMonthTransactions.add(this.transaction1);
        secondMonthTransactions.add(this.transaction3);
        List<Transaction> thirdMonthTransactions = new ArrayList();
        thirdMonthTransactions.add(this.transaction2);
        Mockito.when(this.transactionRepository.findAllByCustomerIdAndTransactionDateBetween((Long)ArgumentMatchers.any(Long.class), (Timestamp)ArgumentMatchers.any(Timestamp.class), (Timestamp)ArgumentMatchers.any(Timestamp.class))).thenReturn(firstMonthTransactions, new List[]{secondMonthTransactions, thirdMonthTransactions});
        Rewards rewards = this.rewardsService.getRewardsByCustomerId(2L);
        Assertions.assertEquals(rewards.getCustomerId(), 2L);
        Assertions.assertEquals(rewards.getFirstMonthRewards(), 125L);
        Assertions.assertEquals(rewards.getSecondMonthRewards(), 225L);
        Assertions.assertEquals(rewards.getThirdMonthRewards(), 100L);
        Assertions.assertEquals(rewards.getTotalRewards(), 450L);
    }

    @Test
    public void testGetRewardsByCustomerIdNoTransactions() {
        Mockito.when(this.transactionRepository.findAllByCustomerIdAndTransactionDateBetween((Long)ArgumentMatchers.any(Long.class), (Timestamp)ArgumentMatchers.any(Timestamp.class), (Timestamp)ArgumentMatchers.any(Timestamp.class))).thenReturn(new ArrayList());
        Rewards rewards = this.rewardsService.getRewardsByCustomerId(1L);
        Assertions.assertEquals(rewards.getCustomerId(), 1L);
        Assertions.assertEquals(rewards.getFirstMonthRewards(), 0L);
        Assertions.assertEquals(rewards.getSecondMonthRewards(), 0L);
        Assertions.assertEquals(rewards.getThirdMonthRewards(), 0L);
        Assertions.assertEquals(rewards.getTotalRewards(), 0L);
    }

    @Test
    public void testGetRewardsPerMonth() {
        List<Transaction> transactions = new ArrayList();
        transactions.add(this.transaction1);
        transactions.add(this.transaction2);
        Long rewardsPerMonth = this.rewardsService.getRewardsPerMonth(transactions);
        Assertions.assertEquals(rewardsPerMonth, 125L);
    }

    @Test
    public void testCalculateRewards50To100() {
        Long rewards = this.rewardsService.calculateRewards(this.transaction2);
        Assertions.assertEquals(rewards, 100L);
    }
}
