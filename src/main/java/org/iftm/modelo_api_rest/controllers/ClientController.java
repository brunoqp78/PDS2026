package org.iftm.modelo_api_rest.controllers;

import java.util.List;

import org.iftm.modelo_api_rest.entities.Client;
import org.iftm.modelo_api_rest.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService service;

    //método principal da api, que retorna todos os clientes
    @GetMapping
    public ResponseEntity<List<Client>> retornaTodosClientes(){ 
        //pega a lista gerada pela service e converte em Json       
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Client> buscarClientePorID(@PathVariable Long id){ 
        Client cli = service.findById(id).get();
        //pega a lista gerada pela service e converte em Json       
        return ResponseEntity.ok(cli);
    }

    @GetMapping("/findName")
    public ResponseEntity<List<Client>> buscarClientePorNome(@RequestParam String name){ 
        List<Client> cli = service.findByName(name);
        //pega a lista gerada pela service e converte em Json       
        return ResponseEntity.ok(cli);
    }    

    @GetMapping("/findNameLike")
    public ResponseEntity<List<Client>> buscarClientePorParteNome(@RequestParam String parteNome){ 
        List<Client> cli = service.findByNameLike(parteNome);
        //pega a lista gerada pela service e converte em Json       
        return ResponseEntity.ok(cli);
    }     

    //fase 2 - Cadastrar, alterar e excluir registro de clientes

    @PostMapping
    public ResponseEntity<Client> cadastrarCliente(@RequestBody Client cli){
        Client cliCad = service.insert(cli);
        return ResponseEntity.ok(cliCad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> modificarCliente(@PathVariable Long id, @RequestBody Client cliModificado){
        Client cliResposta = service.update(id, cliModificado);
        return ResponseEntity.ok(cliResposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarCliente(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
