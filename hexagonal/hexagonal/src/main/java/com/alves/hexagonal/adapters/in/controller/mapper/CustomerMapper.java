package com.alves.hexagonal.adapters.in.controller.mapper;

import com.alves.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.alves.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.alves.hexagonal.application.core.domain.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    // Converte CustomerRequest -> Customer
    public Customer toCustomer(CustomerRequest request) {

        // Mapeamento automático
        Customer customer = modelMapper.map(request, Customer.class);

        // AGORA OS IGNORES DO MAPSTRUCT SÃO FEITOS MANUALMENTE:
        customer.setId(null);          // ignore id
        customer.setAddress(null);     // ignore address
        customer.setIsValidCpf(false); // ignore isValidCpf (ou setar como false)

        return customer;
    }

    // Converte Customer -> CustomerResponse
    public CustomerResponse toCustomerResponse(Customer customer) {
        return modelMapper.map(customer, CustomerResponse.class);
    }
}