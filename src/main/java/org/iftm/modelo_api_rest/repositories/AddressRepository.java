package org.iftm.modelo_api_rest.repositories;

import org.iftm.modelo_api_rest.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{ 
}
