package com.uniloftsky.springframework.springmvcrest.bootstrap;

import com.uniloftsky.springframework.springmvcrest.model.Category;
import com.uniloftsky.springframework.springmvcrest.model.Customer;
import com.uniloftsky.springframework.springmvcrest.repositories.CategoryRepository;
import com.uniloftsky.springframework.springmvcrest.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public DataLoader(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Category> categoryList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();

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

        Customer customer1 = new Customer();
        customer1.setFirstName("Jack");
        customer1.setLastName("Floyd");
        customerList.add(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Chuck");
        customer2.setLastName("Norris");
        customerList.add(customer2);

        customerRepository.saveAll(customerList);
        categoryRepository.saveAll(categoryList);

        log.info("Categories loaded: " + categoryRepository.count());
        log.info("Customers loaded: " + customerRepository.count());
    }
}
