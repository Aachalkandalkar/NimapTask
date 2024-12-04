package com.example.Nimap_Advanto.service;

import com.example.Nimap_Advanto.model.Category;
import com.example.Nimap_Advanto.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.net.ContentHandler;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepo iCategoryRepo;

    public List<Category> getAllCategories(int page) {
        return iCategoryRepo.findAll();
    }

    public Category createCategory(Category category) {
        return iCategoryRepo.save(category);
    }

    public Category getCategoryById(Long id) {
        return iCategoryRepo.findById(id).orElse(null);
    }

    public Category updateCategory(Long id, Category category) {
        if (iCategoryRepo.existsById(id)) {
            category.setId(id);
            return iCategoryRepo.save(category);
        }
        return null;
    }

    public boolean deleteCategory(Long id) {
        if (iCategoryRepo.existsById(id)) {
            iCategoryRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
