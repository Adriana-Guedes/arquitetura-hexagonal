package com.alves.hexagonal.adapters.in.controller.response;



import lombok.Data;

/*
    Aqui já está liberado framework, de lombock em diante
    Classe de Resposta do que do client(ZIPECODE) ira retornar, antigo DTO
 */


@Data
public class AddressResponse {


    private String street;
    private String city;
    private String state;


}
