package com.alves.hexagonal.adapters.in.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {


    //Pra verificar se a api esta funcionando
    @GetMapping("/health" )
    public ResponseEntity<String> HealthController( ){
        return  ResponseEntity.ok().body("ok");
    }
}
