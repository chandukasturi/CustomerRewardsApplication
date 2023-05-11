package com.reward.spring.controller;


import com.reward.spring.entity.Customer;
import com.reward.spring.exception.CustomerNotFoundException;
import com.reward.spring.model.Rewards;
import com.reward.spring.repository.CustomerRepository;
import com.reward.spring.service.RewardsService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping({"/customer"})
public class RewardsController {
    @Autowired
    RewardsService rewardsService;
    @Autowired
    CustomerRepository customerRepository;

    public RewardsController() {
    }

    @GetMapping(
            value = {"/{customerId}/rewards"},
            produces = {"application/json"}
    )
    @ResponseBody
    public ResponseEntity<Rewards> getRewardsByCustomerId(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
        Optional<Customer> customer = this.customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer ID");
        } else {
            Rewards customerRewards = this.rewardsService.getRewardsByCustomerId(customerId);
            return new ResponseEntity(customerRewards, HttpStatus.OK);
        }
    }
}
