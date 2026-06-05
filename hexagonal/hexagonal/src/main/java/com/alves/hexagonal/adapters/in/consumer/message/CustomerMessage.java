package com.alves.hexagonal.adapters.in.consumer.message;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/*
vai ser enviado o cpf para aplicação ficticia simular validação com
 os dados abaixo e dizer se é valido ou não
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {
    private String id;
    private String name;
    private String zipCode;
    private String cpf;
    private Boolean isValidCpf;
}
