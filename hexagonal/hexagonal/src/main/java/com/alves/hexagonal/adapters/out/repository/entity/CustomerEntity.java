package com.alves.hexagonal.adapters.out.repository.entity;


/*
    Como são necessários recursos para salvar, essa classe é criada fora do domain
 */


import com.alves.hexagonal.application.core.domain.Address;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "customers") // notação do mongodb para informar qual o nome da collection
public class CustomerEntity {


    @Id
    private String id;
    private String name;
    private AddressEntity address;  // para salvar objeto
    private String cpf;
    private Boolean isValidCpf;


}
