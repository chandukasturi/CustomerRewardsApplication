package com.reward.spring.controller;

import com.reward.spring.entity.Customer;
import com.reward.spring.exception.CustomerNotFoundException;
import com.reward.spring.model.Rewards;
import com.reward.spring.repository.CustomerRepository;
import com.reward.spring.service.RewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RewardsControllerTest {

    private RewardsService rewardsService;
    private CustomerRepository customerRepository;
    private RewardsController rewardsController;

    @BeforeEach
    public void setUp() {
        rewardsService = mock(RewardsService.class);
        customerRepository = mock(CustomerRepository.class);
        rewardsController = new RewardsController();
        rewardsController.rewardsService = rewardsService;
        rewardsController.customerRepository = customerRepository;
    }

    @Test
    public void testGetRewardsByCustomerIdSuccess() throws CustomerNotFoundException {
        Long customerId = 1L;
        Customer customer = new Customer(customerId, "Chandu");
        Rewards expectedRewards = new Rewards(customerId,300L,100L,100L,100L);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(rewardsService.getRewardsByCustomerId(customerId)).thenReturn(expectedRewards);

        ResponseEntity<Rewards> responseEntity = rewardsController.getRewardsByCustomerId(customerId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedRewards, responseEntity.getBody());
    }

    @Test
    public void testGetRewardsByCustomerIdInvalidCustomerId() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> rewardsController.getRewardsByCustomerId(customerId));
    }
}