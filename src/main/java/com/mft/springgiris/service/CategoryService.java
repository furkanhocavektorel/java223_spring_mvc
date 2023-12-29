package com.mft.springgiris.service;

import com.mft.springgiris.entity.Category;
import com.mft.springgiris.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.repository=categoryRepository;
    }

    public void save(String name){
        Category category= Category.builder()
                .name(name)
                .build();
        repository.save(category);
    }
    public Optional<Category> getById(Long id){
        return repository.findById(id);
    }
    public Optional<Category> getByName(String categoryName){
        return repository.findOptionalByName(categoryName);
    }

}
