package com.uniloftsky.springframework.springmvcrest.service;

import com.uniloftsky.springframework.springmvcrest.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);

}
