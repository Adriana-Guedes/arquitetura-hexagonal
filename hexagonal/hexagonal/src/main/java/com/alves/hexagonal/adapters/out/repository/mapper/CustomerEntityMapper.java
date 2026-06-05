package com.alves.hexagonal.adapters.out.repository.mapper;

/*
   MAPEIA/ OU CONVERSÕES DE DADOS JSON PARA OBJETOS E VICE E VERSA
   ANTIGO DTO
 */


import com.alves.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.alves.hexagonal.application.core.domain.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerEntityMapper {

    @Autowired
    private ModelMapper modelMapper;

    //Conversor de Costumer para CustomerEntity
    public CustomerEntity toCustomerEntity(Customer customer){
        return modelMapper.map(customer, CustomerEntity.class);
    }

    //E de CustomerEntity para Costumer
     public Customer toCustomer(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, Customer.class);
     }
}
