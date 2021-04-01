package com.uniloftsky.springframework.springmvcrest.bootstrap;

import com.uniloftsky.springframework.springmvcrest.model.Category;
import com.uniloftsky.springframework.springmvcrest.model.Customer;
import com.uniloftsky.springframework.springmvcrest.model.Vendor;
import com.uniloftsky.springframework.springmvcrest.repositories.CategoryRepository;
import com.uniloftsky.springframework.springmvcrest.repositories.CustomerRepository;
import com.uniloftsky.springframework.springmvcrest.repositories.VendorRepository;
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
    private final VendorRepository vendorRepository;

    public DataLoader(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Category> categoryList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        List<Vendor> vendorList = new ArrayList<>();


        categoryList.add(new Category("Fruits"));
        categoryList.add(new Category("Dried"));
        categoryList.add(new Category("Fresh"));
        categoryList.add(new Category("Exotic"));
        categoryList.add(new Category("Nuts"));

        customerList.add(new Customer("Jack", "Floyd"));
        customerList.add(new Customer("Chuck", "Norris"));

        vendorList.add(new Vendor("Western Tasty Fruits Ltd."));
        vendorList.add(new Vendor("Exotic Fruits Company"));
        vendorList.add(new Vendor("Home Fruits"));


        customerRepository.saveAll(customerList);
        categoryRepository.saveAll(categoryList);
        vendorRepository.saveAll(vendorList);


        log.info("Categories loaded: " + categoryRepository.count());
        log.info("Customers loaded: " + customerRepository.count());
        log.info("Vendors loaded: " + vendorRepository.count());
    }
}
