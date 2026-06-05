package com.alves.hexagonal.application.ports.in;

import com.alves.hexagonal.application.core.domain.Customer;



/******************* PARA ACESSO AO CASO DE USO *****************************/
public interface FindCustomerByIdInputPort {

    Customer find(String id);

    }

