package com.alves.hexagonal.adapters.in.consumer.mapper;



import com.alves.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.alves.hexagonal.application.core.domain.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class CustomerMessageMapper {

    @Autowired
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    public Customer toCustomer(CustomerMessage message) {

        // converte automaticamente
        Customer c = modelMapper().map(message, Customer.class);

        // você ignorava o address no MapStruct? então mantém o comportamento
        c.setAddress(null);

        return c;
     }
    }