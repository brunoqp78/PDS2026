package org.iftm.modelo_api_rest.controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.iftm.modelo_api_rest.entities.Category;
import org.iftm.modelo_api_rest.entities.Client;
import org.iftm.modelo_api_rest.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    //método principal da api, que retorna todos os clientes
    @GetMapping
    public ResponseEntity<List<Client>> retornaTodosClientes(){ 
        //pega a lista gerada pela service e converte em Json       
        return ResponseEntity.ok(service.findAll());
    }

       

}
