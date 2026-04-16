package org.iftm.modelo_api_rest.repositories;

import java.util.List;
import java.util.Optional;

import org.iftm.modelo_api_rest.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long>{
// --- 5 QUERY METHODS ---
    Optional<Category> findByName(String name);
    List<Category> findByNameStartingWithIgnoreCase(String prefix); // Começa com (Ex: "Pre" acha "Premium")
    List<Category> findByNameEndingWithIgnoreCase(String suffix); // Termina com
    List<Category> findByNameNot(String name); // Traz todas as categorias MENOS a especificada
    List<Category> findByOrderByNameAsc(); // Traz todas as categorias em Ordem Alfabética (A-Z)

    // --- 1 @QUERY (JPQL usando a coleção) ---
    // Busca categorias que possuem pelo menos 'X' número de clientes vinculados
    @Query("SELECT c FROM Category c WHERE size(c.clients) >= :minClients")
    List<Category> findCategoriesWithMinimumClients(@Param("minClients") int minClients);
}
