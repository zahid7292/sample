package com.example.sample.service;

import com.example.sample.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    private Map<Long, Category> cache = new HashMap<>();
    private long counter;
    public CategoryService() {
        this.cache.put(1L, new Category(1L, "Electronics"));
        this.cache.put(2L, new Category(2L, "Grocery"));
        counter = 2;
    }

    public List<Category> findAll() {
        return new ArrayList<>(cache.values());
    }

    public Category save(Category category) {
        category.setId(++counter);
        this.cache.put(category.getId(), category);
        return category;
    }
}
