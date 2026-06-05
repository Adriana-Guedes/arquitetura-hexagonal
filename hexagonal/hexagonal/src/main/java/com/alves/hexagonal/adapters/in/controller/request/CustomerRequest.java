package com.alves.hexagonal.adapters.in.controller.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/*
    Antigo DTO
 */

@Data
public class CustomerRequest {

    //validação, não permite entrada de dados nullo, nem com espaço
    @NotBlank //
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;


}
