package com.uniloftsky.springframework.springmvcrest.repositories;

import com.uniloftsky.springframework.springmvcrest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
