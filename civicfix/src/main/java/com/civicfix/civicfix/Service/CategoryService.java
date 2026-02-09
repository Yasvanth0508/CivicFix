package com.civicfix.civicfix.Service;

import com.civicfix.civicfix.Endity.CategoryEndity;
import com.civicfix.civicfix.Repository.CategoryRepository;

import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEndity createCategory(@NonNull CategoryEndity category) {
        return categoryRepository.save(category);
    }

    public List<CategoryEndity> readAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEndity readCategoryById(@NonNull Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public CategoryEndity updateCategory(@NonNull Long id, CategoryEndity newCategory) {

        CategoryEndity existingCategory =
                categoryRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existingCategory.setName(newCategory.getName());
        existingCategory.setActive(newCategory.isActive());

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(@NonNull Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }

        categoryRepository.deleteById(id);
    }
}
