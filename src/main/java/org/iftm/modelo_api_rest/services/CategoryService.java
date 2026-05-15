package org.iftm.modelo_api_rest.services;

import java.util.List;
import java.util.Optional;

import org.iftm.modelo_api_rest.entities.Category;
import org.iftm.modelo_api_rest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category insert(Category obj) {
        // VALIDAÇÃO OTIMIZADA: O próprio banco verifica se existe! 🚀
        Optional<Category> found = repository.findByName(obj.getName());
        if (found.isPresent()) {
            throw new IllegalArgumentException("A categoria '" + obj.getName() + "' já existe!");
        }
        // VALIDAÇÃO: Nome muito curto 🚀
        if (obj.getName() == null || obj.getName().length() < 3) {
            throw new IllegalArgumentException("O nome da categoria deve ter pelo menos 3 caracteres.");
        }
        return repository.save(obj);
    }
}
