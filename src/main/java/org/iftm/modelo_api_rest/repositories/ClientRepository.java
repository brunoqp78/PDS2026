package org.iftm.modelo_api_rest.repositories;

import org.iftm.modelo_api_rest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{ 
}
