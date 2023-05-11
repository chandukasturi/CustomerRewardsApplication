package com.reward.spring.repository;


import com.reward.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindById_thenReturnCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("Chandu");
        entityManager.persist(customer);
        entityManager.flush();

        Optional<Customer> found = customerRepository.findById(customer.getCustomerId());

        assertThat(found).isPresent();
        assertThat(found.get().getCustomerName()).isEqualTo(customer.getCustomerName());
    }

    @Test
    public void whenFindByInvalidId_thenReturnEmpty() {
        Long invalidId = 101L;

        Optional<Customer> found = customerRepository.findById(invalidId);

        assertThat(found).isEmpty();
    }
}
