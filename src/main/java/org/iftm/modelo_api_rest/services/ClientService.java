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

    //operações básicas
    @Transactional(readOnly = true)
    public List<Client> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id){
        Optional<Client> client = repository.findById(id);
        String nomeMaiusculo = client.get().getName().toUpperCase();
        client.get().setName(nomeMaiusculo);
        return client;
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
        validateIncome(cli.getIncome());    
        validateChildren(cli.getChildren());
        return repository.save(cli);        
    }

    @Transactional
    public Client update(Long id, Client updatedClient){
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()){
            validateIncome(updatedClient.getIncome());
            validateChildren(updatedClient.getChildren());
            Client clientBD = client.get();
            clientBD.setIncome(updatedClient.getIncome());
            clientBD.setChildren(updatedClient.getChildren());
            clientBD.setBirthDate(updatedClient.getBirthDate());
            return repository.save(clientBD);
        }else{
            throw new RuntimeException("Cliente não existente, não é possível modificá-lo!!!");
        }
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    //métodos de validação

    //método que permite validar o salário do cliente, o salário precisa ser maior que 1000.
    private void validateIncome(double income){
        if (income<1000.00){ //se incorreto o salário, retorna uma exception(erro)
            //irei retornar uma IllegalArgumentException
            throw new IllegalArgumentException("O salário deve ser um valor maior ou igual a R$ 1000.00");
        }
    }

    //método que permite validar a quantidade de filhos de um cliente, no máximo 10.
    private void validateChildren(int children){
        if (children > 10){ //se incorreto o salário, retorna uma exception(erro)
            //irei retornar uma IllegalArgumentException
            throw new IllegalArgumentException("A quantidade máxima de filhos aceitos é 10.");
        }
    }  
    
    //métodos que inferem/geram/produzem novas informações

    public String recommendCredit(Long id){
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()){
            double income = client.get().getIncome();
            int children = client.get().getChildren();
            double fator = income / (children+1);
            if (fator>5000){
                return "Cliente com alto nível de crédito!!!!";
            }else if (fator>2000){
                return "Cliente com médio nível de crédito!!!!";
            }else{
                return "Cliente com baixo nível de crédito!!!!";
            }
        }else{
            throw new IllegalArgumentException("Não existe cliente com esse ID!!!");
        }
    }

}
