package org.iftm.modelo_api_rest.services;

import java.util.List;
import java.util.Optional;

import org.iftm.modelo_api_rest.entities.Client;
import org.iftm.modelo_api_rest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired // indicando ao Spring Boot a necessidade de instanciar um objeto repository durante a execução
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public List<Client> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id){
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public Client findClientById(Long id){
        return repository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    public List<Client> findByName(String name){
        return repository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Client> findByNameLike(String namePartial){
        return repository.findByNameContainingIgnoreCase(namePartial);
    }

    @Transactional
    public Client insert(Client cli){
        return repository.save(cli);
    }

    @Transactional
    public Client update(Client updatedClient){
        return repository.save(updatedClient);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

}
