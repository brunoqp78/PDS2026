package org.iftm.modelo_api_rest;

import java.time.Instant;
import java.util.List;

import org.iftm.modelo_api_rest.entities.Address;
import org.iftm.modelo_api_rest.entities.Client;
import org.iftm.modelo_api_rest.repositories.AddressRepository;
import org.iftm.modelo_api_rest.repositories.ClientRepository;
import org.iftm.modelo_api_rest.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ModeloApiRestApplication implements CommandLineRunner {

    // --- INJEÇÃO DOS REPOSITORIES (Para testar nossas consultas) ---
    //relacionado a atividade A2
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;

    //relacionado a atividade A3
    @Autowired
    private ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(ModeloApiRestApplication.class, args);
    }

    @Override
    @Transactional // Mantém a conexão aberta para consultas complexas
    public void run(String... args) throws Exception {

        System.out.println("\n=================================================");
        System.out.println("🚀 Camada Service : TESTES DOS SERVIÇOS BÁSICOS");
        System.out.println("=================================================\n");
        Client client = new Client(null, "Bruno", "11111111111", 8000.00, Instant.now(), 2);
        Client clienteSalvo = clientService.insert(client);
        System.out.println("O novo cliente tem ID : " + clienteSalvo.getId());

        System.out.println("\nBuscando todos clientes:");
        List<Client> clientes = clientService.findAll();
        for (Client c : clientes) {
            System.out.println(" - " + c.getName() + " (R$ " + c.getIncome() + ")");
        }         

        System.out.println("\nBuscando todos clientes que contém da no nome:");
        clientes = clientService.findByNameLike("da");
        for (Client c : clientes) {
            System.out.println(" - " + c.getName() + " (R$ " + c.getIncome() + ")");
        }         


        System.out.println("\n=================================================");
        System.out.println("🚀 Camada Repository : INICIANDO BATERIA DE TESTES DO SISTEMA");
        System.out.println("=================================================\n");

        // -------------------------------------------------------------
        // TESTE 3: QUERY METHODS E @QUERY (REPOSITORIES)
        // -------------------------------------------------------------
        System.out.println("\n--- 1. TESTANDO CONSULTAS NO BANCO (QUERY METHODS) ---");
        
        System.out.println("Buscando endereços no estado de 'SP':");
        List<Address> enderecosSP = addressRepository.findByState("SP");
        enderecosSP.forEach(end -> 
            System.out.println(" - " + end.getStreet() + " (" + end.getCity() + ")")
        );

        System.out.println("\nBuscando clientes que moram em 'São Paulo' (usando nosso @Query customizado):");
        List<Client> clientesSP = clientRepository.findClientsByCity("São Paulo");
        clientesSP.forEach(c -> 
            System.out.println(" - " + c.getName() + " | Renda: R$ " + c.getIncome())
        );

        System.out.println("\nBuscando clientes com renda MAIOR ou IGUAL a R$ 6000:");
        List<Client> clientesRicos = clientRepository.findByIncomeGreaterThanEqual(6000.0);
        clientesRicos.forEach(c -> 
            System.out.println(" - " + c.getName() + " (R$ " + c.getIncome() + ")")
        );

        System.out.println("\n=================================================");
        System.out.println("✅ TESTES FINALIZADOS COM SUCESSO!");
        System.out.println("=================================================\n");
    }
}
