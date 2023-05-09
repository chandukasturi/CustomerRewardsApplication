package com.reward.spring.service;

import com.reward.spring.entity.Transaction;
import com.reward.spring.model.Rewards;
import com.reward.spring.repository.TransactionRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardsServiceImpl implements RewardsService {
    public static final int daysInMonths = 30;
    @Autowired
    TransactionRepository transactionRepository;

    public RewardsServiceImpl() {
    }

    public Rewards getRewardsByCustomerId(Long customerId) {
        Timestamp firstMonthTimestamp = this.getTimestampMonthlyDates(30);
        Timestamp secondMonthTimestamp = this.getTimestampMonthlyDates(60);
        Timestamp thirdMonthTimestamp = this.getTimestampMonthlyDates(90);
        List<Transaction> firstMonthTransactions = this.transactionRepository.findAllByCustomerIdAndTransactionDateBetween(customerId, firstMonthTimestamp, Timestamp.from(Instant.now()));
        List<Transaction> secondMonthTransactions = this.transactionRepository.findAllByCustomerIdAndTransactionDateBetween(customerId, secondMonthTimestamp, firstMonthTimestamp);
        List<Transaction> thirdMonthTransactions = this.transactionRepository.findAllByCustomerIdAndTransactionDateBetween(customerId, thirdMonthTimestamp, secondMonthTimestamp);
        Long firstMonthRewardPoints = this.getRewardsPerMonth(firstMonthTransactions);
        Long secondMonthRewardPoints = this.getRewardsPerMonth(secondMonthTransactions);
        Long thirdMonthRewardPoints = this.getRewardsPerMonth(thirdMonthTransactions);
        Rewards customerRewards = new Rewards();
        customerRewards.setCustomerId(customerId);
        customerRewards.setFirstMonthRewards(firstMonthRewardPoints);
        customerRewards.setSecondMonthRewards(secondMonthRewardPoints);
        customerRewards.setThirdMonthRewards(thirdMonthRewardPoints);
        customerRewards.setTotalRewards(firstMonthRewardPoints + secondMonthRewardPoints + thirdMonthRewardPoints);
        return customerRewards;
    }

    public Long getRewardsPerMonth(List<Transaction> transactions) {
        return transactions.stream().map(this::calculateRewards).mapToLong(Long::longValue).sum();
    }

    public Long calculateRewards(Transaction t) {
        if (t.getTransactionAmount() > 0.0 && t.getTransactionAmount() <= 50.0) {
            return Math.round(t.getTransactionAmount());
        } else {
            return t.getTransactionAmount() > 50.0 ? Math.round(t.getTransactionAmount() - 50.0) * 2L + 50L : 0L;
        }
    }

    public Timestamp getTimestampMonthlyDates(int days) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays((long)days));
    }
}
