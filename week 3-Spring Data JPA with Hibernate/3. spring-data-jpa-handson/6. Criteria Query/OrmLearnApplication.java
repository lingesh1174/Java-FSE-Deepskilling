package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.model.ProductSearchFilter;
import com.cognizant.orm_learn.repository.ProductCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private ProductCriteriaRepository productCriteriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        simulateAmazonSearch();
    }

    private void simulateAmazonSearch() {
        System.out.println("Simulating Amazon-style product search using Criteria Query...");

        ProductSearchFilter filter = new ProductSearchFilter();

        filter.setKeyword("laptop");

        filter.setRamSize("16GB");
        filter.setOs("Windows 11");

        List<Product> results = productCriteriaRepository.searchProducts(filter);

        if (results.isEmpty()) {
            System.out.println("No matching products found.");
        } else {
            System.out.println("Matching products based on filter:");
            for (Product p : results) {
                System.out.printf("ID: %d | Name: %s | CPU: %s | RAM: %s | Speed: %.2f GHz | HDD: %s | OS: %s | Review: %s | Weight: %.2f kg\n",
                        p.getId(), p.getName(), p.getCpu(), p.getRamSize(), p.getCpuSpeed(), p.getHardDiskSize(),
                        p.getOs(), p.getCustomerReview(), p.getWeight());
            }
        }
    }
}