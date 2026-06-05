package com.alves.hexagonal.application.core.usecase;


import com.alves.hexagonal.application.core.domain.Customer;
import com.alves.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.alves.hexagonal.application.ports.out.FindAdressByZipCodeOutputPort;
import com.alves.hexagonal.application.ports.out.InsertCustmerOutputPort;
import com.alves.hexagonal.application.ports.out.SendCpfForValidationOutputPort;


/*
    Como não tem @Bean (@Component) necessário configurar na pasta de configuração para que o spring consiga localizado
 */
public class InsertCustomerUseCase  implements InsertCustomerInputPort {


    /* ANTIGA SERVICE - MVC
    não pode usar o @Autowired do spring, com isso será necessário injetar a classe via construtor
    */
    /******************* INJEÇÃO DE DEPENDENCIA VIA CONTRUTOR *****************************/
    private final FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort;
    private final InsertCustmerOutputPort insertCustmerOutputPort;
    // envio de cpf para a fila do kafka para validar
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    /******************* CONSTRUTOR FindAdressByZipCodeOutputPort *****************************/
    public InsertCustomerUseCase(
            FindAdressByZipCodeOutputPort findAdressByZipCodeOutputPort,
            InsertCustmerOutputPort insertCustmerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort){
        this.findAdressByZipCodeOutputPort = findAdressByZipCodeOutputPort;
        this.insertCustmerOutputPort = insertCustmerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }



    /********************** CASO DE USO DE INSERÇÃO *******************************/
    /******************* CHAMADA DO MÉTODO COM A AÇÃO *****************************/

    // Para executar a ação necessário criar uma porta de saida e implenta-la aqui sobrescrevendo o método
    @Override //cep será buscado por outro microsserviço externo
    public void insert(Customer customer, String zipCode){
        var address = findAdressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustmerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());//envio para o kafka
    }
}
