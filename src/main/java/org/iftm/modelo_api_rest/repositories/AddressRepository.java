package org.iftm.modelo_api_rest.repositories;

import java.util.List;

import org.iftm.modelo_api_rest.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long>{ 
    // --- 5 QUERY METHODS ---
    List<Address> findByCityIgnoreCase(String city);
    List<Address> findByState(String state);
    List<Address> findByZipCode(String zipCode);
    List<Address> findByStreetContainingIgnoreCase(String street);
    List<Address> findByCityAndState(String city, String state); // Combina duas colunas com AND

    // --- 1 @QUERY (SQL Nativo) ---
    // Conta quantos endereços existem em um determinado estado usando SQL raiz
    @Query(value = "SELECT COUNT(*) FROM tb_address WHERE state = :state", nativeQuery = true)
    long countAddressesByStateNative(@Param("state") String state);
}
