package com.reward.spring.model;

public class Rewards {
    private long customerId;
    private long totalRewards;
    private long firstMonthRewards;
    private long secondMonthRewards;
    private long thirdMonthRewards;

    public Rewards() {
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getTotalRewards() {
        return this.totalRewards;
    }

    public void setTotalRewards(long totalRewards) {
        this.totalRewards = totalRewards;
    }

    public long getFirstMonthRewards() {
        return this.firstMonthRewards;
    }

    public void setFirstMonthRewards(long firstMonthRewards) {
        this.firstMonthRewards = firstMonthRewards;
    }

    public long getSecondMonthRewards() {
        return this.secondMonthRewards;
    }

    public void setSecondMonthRewards(long secondMonthRewards) {
        this.secondMonthRewards = secondMonthRewards;
    }

    public long getThirdMonthRewards() {
        return this.thirdMonthRewards;
    }

    public void setThirdMonthRewards(long thirdMonthRewards) {
        this.thirdMonthRewards = thirdMonthRewards;
    }
}
