package com.alves.hexagonal.adapters.out;

import com.alves.hexagonal.adapters.out.repository.CustomerRepository;
import com.alves.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.alves.hexagonal.application.core.domain.Customer;
import com.alves.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/******************* É UMA ADAPTAÇÃO DA PORTA DE SAIDA OU DE ENTRADA *****************************/
/******************* NESSE CASO É DA PORTA DE SAIDA *****************************/


@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;




    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
