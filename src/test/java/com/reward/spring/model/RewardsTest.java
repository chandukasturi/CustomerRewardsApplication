package com.reward.spring.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RewardsTest {
    @Test
    public void testConstructorAndGetters() {
        long customerId = 1L;
        long totalRewards = 100L;
        long firstMonthRewards = 30L;
        long secondMonthRewards = 40L;
        long thirdMonthRewards = 30L;

        Rewards rewards = new Rewards(customerId, totalRewards, firstMonthRewards, secondMonthRewards, thirdMonthRewards);

        assertEquals(customerId, rewards.getCustomerId());
        assertEquals(totalRewards, rewards.getTotalRewards());
        assertEquals(firstMonthRewards, rewards.getFirstMonthRewards());
        assertEquals(secondMonthRewards, rewards.getSecondMonthRewards());
        assertEquals(thirdMonthRewards, rewards.getThirdMonthRewards());
    }

    @Test
    public void testSetters() {
        long customerId = 1L;
        long totalRewards = 100L;
        long firstMonthRewards = 30L;
        long secondMonthRewards = 40L;
        long thirdMonthRewards = 30L;

        Rewards rewards = new Rewards();

        rewards.setCustomerId(customerId);
        rewards.setTotalRewards(totalRewards);
        rewards.setFirstMonthRewards(firstMonthRewards);
        rewards.setSecondMonthRewards(secondMonthRewards);
        rewards.setThirdMonthRewards(thirdMonthRewards);

        assertEquals(customerId, rewards.getCustomerId());
        assertEquals(totalRewards, rewards.getTotalRewards());
        assertEquals(firstMonthRewards, rewards.getFirstMonthRewards());
        assertEquals(secondMonthRewards, rewards.getSecondMonthRewards());
        assertEquals(thirdMonthRewards, rewards.getThirdMonthRewards());
    }
}
