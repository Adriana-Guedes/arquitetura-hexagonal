package com.alves.hexagonal.application.ports.out;

import com.alves.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    //Retorna um optional porque pode ter o usuario ou não no banco de dados
    Optional<Customer> find(String id);
}
