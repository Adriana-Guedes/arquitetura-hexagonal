package com.alves.hexagonal.application.core.usecase;

import com.alves.hexagonal.application.core.domain.Customer;
import com.alves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.alves.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.alves.hexagonal.application.ports.out.FindAdressByZipCodeOutputPort;
import com.alves.hexagonal.application.ports.out.UpdateCustomerOutputPort;


/*
    injeta as portas para reaproveitar os métodos já existentes
 */
public class UpdateCustomerUseCase  implements UpdateCustomerInputPort {



    /******************* INJEÇÃO DE DEPENDENCIA VIA CONTRUTOR *****************************/
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAdressByZipCodeOutputPort = findAdressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }



    /* Nesse caso de uso temos:
        o Reaproveitamento da porta de entrada que busca usuário por 'id'
        o Reaproveitamento da porta de saida que busca o cep
        e a porta de saida 'update' para salvar no banco esse usuário
        necessário criar o adaptador para salvar no banco
     */

    /********************** CASO DE USO DE INSERÇÃO *******************************/
    /******************* CHAMADA DO MÉTODO COM A AÇÃO *****************************/

    // Para executar a ação necessário criar uma porta de entrada e implenta-la aqui sobrescrevendo o método
    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAdressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);

    }
}



