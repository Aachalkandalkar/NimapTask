package com.example.Nimap_Advanto.repository;

import com.example.Nimap_Advanto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product,Long> {

}
