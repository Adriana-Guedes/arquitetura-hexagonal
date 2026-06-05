package com.alves.hexagonal.application.ports.in;


import com.alves.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

void update(Customer customer, String zipCode);


}
