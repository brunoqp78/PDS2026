package org.iftm.modelo_api_rest.entity;

import java.time.Instant;

public class ClientTest {
    public static void main(String[] args) {
        Client client01 = new Client();

        client01.setName("João");
        client01.setCpf("111111111-11");
        client01.setIncome(4500.00);        
        client01.setBirthDate(Instant.parse("1980-03-15T20:15:30.00Z"));
        client01.setChildren(2);

        Client client02 = new Client(null, "Maria", "22222222222", 4500.00, Instant.now(), 2);

        System.out.println(" Cliente 1 criado com sucesso!");
        System.out.println("Nome: " + client01.getName());
        System.out.println("CPF: " + client01.getCpf());
        System.out.println("Salário: R$ " + client01.getIncome());        
        System.out.println("Data de nascimento " + client01.getBirthDate());        

        System.out.println(" Cliente 2 criado com sucesso!");
        System.err.println(client02);

    }
}
