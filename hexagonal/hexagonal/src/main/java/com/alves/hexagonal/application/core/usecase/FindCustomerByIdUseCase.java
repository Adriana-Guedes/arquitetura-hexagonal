package com.alves.hexagonal.application.core.usecase;


import com.alves.hexagonal.application.core.domain.Customer;
import com.alves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.alves.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {



    /******************* INJEÇÃO DE DEPENDENCIA VIA CONSTRUTOR *****************************/
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    /******************* CONSTRUTOR FindCustomerByIdOutputPort *****************************/
    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort){
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }



    /********************** CASO DE USO DE INSERÇÃO *******************************/
    /******************* CHAMADA DO MÉTODO COM A AÇÃO *****************************/

    // Para executar a ação necessário criar uma porta de entrada e implenta-la aqui sobrescrevendo o método

    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("O Customer not Found"));

    }

}
