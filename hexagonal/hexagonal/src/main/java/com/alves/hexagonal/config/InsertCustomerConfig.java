package com.alves.hexagonal.config;

/*
        BEANS PARA CASO DE USO
 */

import com.alves.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.alves.hexagonal.adapters.out.InsertCustomerAdapter;
import com.alves.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.alves.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {


    /*
        INJETAR SOMENTE OS ADAPTERS CONFORME AS PORTAS UTILIZADAS
    */

    @Bean
    public InsertCustomerUseCase inserCostumerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,insertCustomerAdapter,sendCpfValidationAdapter);
    }
}
