package org.iftm.modelo_api_rest.repositories;

import java.util.List;
import java.util.Optional;

import org.iftm.modelo_api_rest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long>{
// --- 5 QUERY METHODS ---
    Optional<Product> findByName(String name);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByPriceLessThanEqual(Double price); // Preço menor ou igual (ótimo para "Até R$ 100")
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice); // Faixa de preço
    List<Product> findByPriceGreaterThanOrderByPriceDesc(Double price); // Preço maior que, ordenado do mais caro pro mais barato

    // --- 1 @QUERY (JPQL com Sub-consulta) ---
    // Busca produtos que custam ABAIXO da média geral da loja
    @Query("SELECT p FROM Product p WHERE p.price < (SELECT AVG(p2.price) FROM Product p2)")
    List<Product> findProductsBelowAveragePrice();
}
