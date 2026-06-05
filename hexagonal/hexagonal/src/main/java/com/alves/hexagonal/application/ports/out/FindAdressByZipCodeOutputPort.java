package com.alves.hexagonal.application.ports.out;

import com.alves.hexagonal.application.core.domain.Address;



/*  PORTA DE SAIDA DA APLICAÇÃO PARA OUTROS SERVIÇOS
    Só os métodos relacionados a classe
    necessário criar o client para acessar o microsservicos de busca de endereço
    para que conseguir criar os adaptadores da porta de saida
 */
public interface FindAdressByZipCodeOutputPort {

    Address find(String zipCode); //retorna o endereço
}
