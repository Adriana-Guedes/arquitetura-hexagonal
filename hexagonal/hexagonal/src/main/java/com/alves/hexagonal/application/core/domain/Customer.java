package com.alves.hexagonal.application.core.domain;



/*
    Não pode usar essas classes para salvar,
    pois precisam de recursos do spring,
    necessário utilizar classes entitys criadas na pasta repostory - entity
 */



public class Customer {

    private String id;
    private String name;
    private Address address;  //outro objeto
    private String cpf;
    private Boolean isValidCpf;



    //construtores
    // quando criar um cliente, ele sempre deve ter um cpf não validado ainda
    public Customer(){
        this.isValidCpf = false;

    }



    public Customer(String id, Boolean isValidCpf, String cpf, Address address, String name) {
        this.id = id;
        this.isValidCpf = isValidCpf;
        this.cpf = cpf;
        this.address = address;
        this.name = name;
    }



    // Como deve ser isolado não se usa fremework
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf(){
            return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getIsValidCpf() {
        return isValidCpf;
    }

    public void setIsValidCpf(Boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }






}
