package com.alves.hexagonal.adapters.out.client.mapper;



    /*
   MAPEIA/ OU CONVERSÕES DE DADOS JSON PARA OBJETOS E VICE E VERSA
   ANTIGO DTO

 */


import com.alves.hexagonal.adapters.in.controller.response.AddressResponse;
import com.alves.hexagonal.application.core.domain.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressResponseMapper {
    @Autowired
    private ModelMapper modelMapper;


    //Converte um AdressResponse em Address
    public Address toAddress(AddressResponse addressResponse){
        return modelMapper.map(addressResponse, Address.class);
    }
}
