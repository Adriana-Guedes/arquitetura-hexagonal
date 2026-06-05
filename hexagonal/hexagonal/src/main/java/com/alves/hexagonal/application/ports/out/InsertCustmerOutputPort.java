package com.alves.hexagonal.application.ports.out;


import com.alves.hexagonal.application.core.domain.Customer;



/******************* INTERFACE/ CONTRATO DA AÇÃO IMPLEMENTADA NA REPOSITORY *****************************/
public interface InsertCustmerOutputPort {
    void insert(Customer customer);

}
