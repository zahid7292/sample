package com.example.sample.restcontroller;

import com.example.sample.model.Category;
import com.example.sample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Category> categoryList = categoryService.findAll();
        return ResponseEntity.ok(categoryList) ;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Category category) {
        category = categoryService.save(category);
        return ResponseEntity.ok(category);
    }
}
