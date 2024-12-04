package com.example.Nimap_Advanto.service;

import com.example.Nimap_Advanto.model.Product;
import com.example.Nimap_Advanto.repository.ICategoryRepo;
import com.example.Nimap_Advanto.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepo iProductRepo;

    @Autowired
    private ICategoryRepo iCategoryRepo;


    public List<Product> getAllProducts(int page) {
        return iProductRepo.findAll();
    }

    public Product createProduct(Product product) {
        return iCategoryRepo.findById(product.getCategory().getId())
                .map(category -> {
                    product.setCategory(category);
                    return iProductRepo.save(product);
                })
                .orElse(null);
    }

    public Product getProductById(Long id) {
        return iProductRepo.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        return iProductRepo.findById(id)
                .map(existingProduct -> iCategoryRepo.findById(product.getCategory().getId())
                        .map(category -> {
                            product.setId(id);
                            product.setCategory(category);
                            return iProductRepo.save(product);
                        })
                        .orElse(null))
                .orElse(null);
    }

    public boolean deleteProduct(Long id) {
        if (iProductRepo.existsById(id)) {
            iProductRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
