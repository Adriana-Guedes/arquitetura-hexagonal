package com.alves.hexagonal.config;


import com.alves.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.alves.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FindCustomerByIdConfig {




    /*
        INJETAR SOMENTE OS ADAPTERS CONFORME AS PORTAS UTILIZADAS
    */

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ){
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}
