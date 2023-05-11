package com.reward.spring.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    void testGettersAndSetters() {
        Customer customer = new Customer();
        customer.setCustomerId(101L);
        customer.setCustomerName("Chandu");

        assertThat(customer.getCustomerId()).isEqualTo(101L);
        assertThat(customer.getCustomerName()).isEqualTo("Chandu");
    }

    @Test
    void testConstructorWithParams() {
        Customer customer = new Customer(101L, "Chandu");

        assertThat(customer.getCustomerId()).isEqualTo(101L);
        assertThat(customer.getCustomerName()).isEqualTo("Chandu");
    }
}