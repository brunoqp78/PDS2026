package org.iftm.modelo_api_rest.services;

import java.util.List;

import org.iftm.modelo_api_rest.entities.Product;
import org.iftm.modelo_api_rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product insert(Product obj) {
        // VALIDAÇÃO: Preço mínimo 🚀
        if (obj.getPrice() == null || obj.getPrice() < 1.0) {
            throw new IllegalArgumentException("O preço do produto não pode ser menor que R$ 1,00.");
        }
        return repository.save(obj);
    }

    // REGRA DE NEGÓCIO: Aplicar desconto em massa (%) 🚀
    public void applyDiscountToAll(Double percentage) {
        List<Product> products = repository.findAll();
        for (Product p : products) {
            Double currentPrice = p.getPrice();
            p.setPrice(currentPrice - (currentPrice * (percentage / 100)));
            repository.save(p);
        }
    }
}