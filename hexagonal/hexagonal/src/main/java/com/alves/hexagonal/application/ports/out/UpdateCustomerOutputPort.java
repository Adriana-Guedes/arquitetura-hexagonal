package com.alves.hexagonal.application.ports.out;

import com.alves.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
