package org.iftm.modelo_api_rest.repositories;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.iftm.modelo_api_rest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long>{ 
    // --- 5 QUERY METHODS ---
    List<Client> findByNameContainingIgnoreCase(String name); // Busca por pedaço do nome ignorando maiúsculas
    Optional<Client> findByCpf(String cpf); // Busca CPF exato
    List<Client> findByName(String name); // Busca por nome exato.
    List<Client> findByIncomeGreaterThanEqual(Double income); // Renda maior ou igual
    List<Client> findByBirthDateBetween(Instant start, Instant end); // Nascidos num período de tempo
    List<Client> findByChildrenOrderByIncomeDesc(Integer children); // Busca por nº de filhos e ordena pela renda

    // --- 1 @QUERY (JPQL) ---
    // Busca todos os clientes que moram em uma cidade específica (Navegando pelos objetos)
    @Query("SELECT c FROM Client c WHERE c.address.city = :city")
    List<Client> findClientsByCity(@Param("city") String city);

}
