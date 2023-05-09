package com.reward.spring.repository;


import com.reward.spring.entity.Customer;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(Long customerId);
}
