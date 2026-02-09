package com.civicfix.civicfix.Controller;

import com.civicfix.civicfix.Endity.CategoryEndity;
import com.civicfix.civicfix.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/civicf+*ix")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category/create")
    public CategoryEndity create(@RequestBody CategoryEndity category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/category/readall")
    public List<CategoryEndity> readAll() {
        return categoryService.readAllCategories();
    }

    @GetMapping("/category/readbyid/{id}")
    public CategoryEndity readById(@PathVariable Long id) {
        return categoryService.readCategoryById(id);
    }

    @PutMapping("/category/update/{id}")
    public CategoryEndity update(@PathVariable Long id,
                                  @RequestBody CategoryEndity category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/category/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
