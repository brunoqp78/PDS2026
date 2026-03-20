package org.iftm.modelo_api_rest.repositories;

import org.iftm.modelo_api_rest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
