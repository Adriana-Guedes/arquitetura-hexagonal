package com.alves.hexagonal.config;


import com.alves.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.alves.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.alves.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.alves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UpdateCustomerConfig {


    /*
        INJETAR SOMENTE OS ADAPTERS CONFORME AS PORTAS UTILIZADAS
    */


    //Exceção do findCustomerByIdInputPort nesse caso(por que foi usado a porta de entrada)
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){

        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeAdapter,updateCustomerAdapter);
    }

}
