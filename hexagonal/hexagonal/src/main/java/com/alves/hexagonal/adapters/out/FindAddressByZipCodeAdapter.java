package com.alves.hexagonal.adapters.out;

/*
    Não faz parte do cor pode usar o framework qualquer
    Adapter é a implementação da porta de entrada e de saida
 */

import com.alves.hexagonal.adapters.out.client.FindAdressByZipeCodeClient;

import com.alves.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.alves.hexagonal.application.core.domain.Address;
import com.alves.hexagonal.application.ports.out.FindAdressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/******************* É UMA ADAPTAÇÃO DA PORTA DE SAIDA OU DE ENTRADA *****************************/
/******************* NESSE CASO É DA PORTA DE SAIDA *****************************/


@Component
public class FindAddressByZipCodeAdapter implements FindAdressByZipCodeOutputPort {

    //Injeção de dependencia
    @Autowired
    private FindAdressByZipeCodeClient findAdressByZipeCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;




    @Override
    public Address find(String zipCode) {
        //O metodo precisa retornar um endereço(Address) não um addressResponse,
        // então necessário usar mapper para converter em Address, e isso acontece na classe do cliente.mapper
        var addressResponse = findAdressByZipeCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
