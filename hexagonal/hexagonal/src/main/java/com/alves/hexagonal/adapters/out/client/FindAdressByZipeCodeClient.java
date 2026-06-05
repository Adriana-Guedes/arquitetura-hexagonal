package com.alves.hexagonal.adapters.out.client;

import com.alves.hexagonal.adapters.in.controller.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


    /*********************** PARA ACESSAR O MICROSSERVIÇO **************************************/


@FeignClient(
        name = "FindAdressByZipeCodeClient", // nome da propria interface
        url = "${drikalves.client.address.url}" // url do microsserviço informado no .yml
)


/*  UMA VEZ ACESSADO ACIMA O MICROSERVIÇO,
ELE PRECISA DAR UMA RESPOSTA DE UM ENDEREÇO
*/
public interface FindAdressByZipeCodeClient {

    @GetMapping("/{zipCode}") //zipCode será substituído pelo ‘String’ ZipCode informado no find
    AddressResponse find(@PathVariable("zipCode") String zipCode);




}
