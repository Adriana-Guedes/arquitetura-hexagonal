package com.alves.hexagonal.application.core.usecase;


import com.alves.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.alves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.alves.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {


    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ){

        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }



    /********************** CASO DE USO DE INSERÇÃO *******************************/
    /******************* CHAMADA DO MÉTODO COM A AÇÃO *****************************/

    // Para executar a ação necessário criar uma porta de entrada e implenta-la aqui sobrescrevendo o método
    @Override
    public void delete (String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);



    }

}
