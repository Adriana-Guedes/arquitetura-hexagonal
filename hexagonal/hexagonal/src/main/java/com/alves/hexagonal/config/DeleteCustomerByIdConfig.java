package com.alves.hexagonal.config;


import com.alves.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.alves.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.alves.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.alves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {


    //Exceção do findCustomerByIdInputPort nesse caso(por que foi usado a porta de entrada)
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter

    ){
        return  new DeleteCustomerByIdUseCase(findCustomerByIdInputPort,deleteCustomerByIdAdapter);
    }
}
