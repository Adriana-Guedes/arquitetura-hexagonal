package com.alves.hexagonal.adapters.out.repository.entity;

/*
    Como são necessários recursos para salvar, essa classe é criada fora do domain
 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
public class AddressEntity {

    private String street;
    private String city;
    private String state;



}
