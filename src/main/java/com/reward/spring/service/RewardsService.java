package com.reward.spring.service;

import com.reward.spring.model.Rewards;

public interface RewardsService {
    Rewards getRewardsByCustomerId(Long customerId);
}
