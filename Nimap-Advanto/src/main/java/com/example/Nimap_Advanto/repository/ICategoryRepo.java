package com.example.Nimap_Advanto.repository;

import com.example.Nimap_Advanto.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Category,Long> {


}
