package com.alves.hexagonal.adapters.in.controller.response;

import com.alves.hexagonal.application.core.domain.Address;
import lombok.Data;


/*
    Aqui já está liberado framework, de lombock em diante
    Classe de Resposta do que o cliente ira nos retornar, antigo DTO
 */


@Data
public class CustomerResponse {

    private String name;
    private Address address;  //outro objeto
    private String cpf;
    private Boolean insValidCpf;
}
