package com.alves.hexagonal.application.ports.in;

import com.alves.hexagonal.application.core.domain.Customer;



/******************* PARA ACESSO AO CASO DE USO *****************************/
public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
