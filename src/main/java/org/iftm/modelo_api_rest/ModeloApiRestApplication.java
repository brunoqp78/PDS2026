package org.iftm.modelo_api_rest;

import java.time.Instant;
import java.util.List;

import org.iftm.modelo_api_rest.entities.Address;
import org.iftm.modelo_api_rest.entities.Client;
import org.iftm.modelo_api_rest.repositories.AddressRepository;
import org.iftm.modelo_api_rest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModeloApiRestApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(ModeloApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address1 = new Address(null, "Joao Naves", "Udi", "mg", "38400000");
		addressRepository.save(address1);
		Client cliente1 = new Client(null, "Bruno Queiroz", "11111111111", 5000.00, Instant.now(), 2);
		cliente1.setAddress(address1);
		clientRepository.save(cliente1);

		System.out.println();
		System.out.println();
		System.out.println();
		List<Client> list = clientRepository.findAll();
		for (Client cli : list) {
			System.out.println(cli.getName() + " mora na rua " + cli.getAddress().getStreet());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		Client client2 = clientRepository.findById(1L).get();
		System.out.println(client2.getName());

	}

}
