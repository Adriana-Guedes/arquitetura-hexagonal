package com.alves.hexagonal.adapters.out;


import com.alves.hexagonal.adapters.out.repository.CustomerRepository;
import com.alves.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.alves.hexagonal.application.core.domain.Customer;
import com.alves.hexagonal.application.ports.out.InsertCustmerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class InsertCustomerAdapter implements InsertCustmerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);


        System.out.println("Adapter customer :" + customer.getName());
        System.out.println("Adapter cpf :" + customer.getCpf());
        System.out.println("Adapter endereço :" + customer.getAddress());
        System.out.println("Adapter isvalidcpf :" + customer.getIsValidCpf());
        System.out.println("Adapter customerEntity:" +customerEntity);


    }
}
