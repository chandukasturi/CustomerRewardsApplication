package com.reward.spring.service;

import com.reward.spring.entity.Customer;
import com.reward.spring.exception.CustomerNotFoundException;

public interface CustomerService {

    Customer getCustomerById(Long customerId) throws CustomerNotFoundException;
}
