package com.uniloftsky.springframework.springmvcrest.bootstrap;

import com.uniloftsky.springframework.springmvcrest.model.Category;
import com.uniloftsky.springframework.springmvcrest.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DataLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Category> categoryList = new ArrayList<>();

        Category fruits = new Category();
        fruits.setName("Fruits");
        categoryList.add(fruits);

        Category dried = new Category();
        dried.setName("Dried");
        categoryList.add(dried);

        Category fresh = new Category();
        fresh.setName("Fresh");
        categoryList.add(fresh);

        Category exotic = new Category();
        exotic.setName("Exotic");
        categoryList.add(exotic);

        Category nuts = new Category();
        nuts.setName("Nuts");
        categoryList.add(nuts);

        categoryRepository.saveAll(categoryList);

        log.info("Data loaded: " + categoryRepository.count());
    }
}
