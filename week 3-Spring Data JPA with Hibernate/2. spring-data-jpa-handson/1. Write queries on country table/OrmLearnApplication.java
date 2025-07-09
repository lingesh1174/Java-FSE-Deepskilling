package com.cognizant.orm_learn;

import java.util.List;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        testGetCountriesByPartialName();
        testGetCountriesByPartialNameSorted();
        testGetCountriesStartingWith();
    
    }

    private static void testGetCountriesByPartialName() {
        LOGGER.info("Start: testGetCountriesByPartialName");
        List<Country> countries = countryService.getCountriesByPartialName("ou");
        countries.forEach(c -> LOGGER.debug("Country: {}", c));
        LOGGER.info("End: testGetCountriesByPartialName");
    }

    private static void testGetCountriesByPartialNameSorted() {
        LOGGER.info("Start: testGetCountriesByPartialNameSorted");
        List<Country> countries = countryService.getCountriesByPartialNameSorted("ou");
        countries.forEach(c -> LOGGER.debug("Sorted Country: {}", c));
        LOGGER.info("End: testGetCountriesByPartialNameSorted");
    }

    private static void testGetCountriesStartingWith() {
        LOGGER.info("Start: testGetCountriesStartingWith");
        List<Country> countries = countryService.getCountriesStartingWith("Z");
        countries.forEach(c -> LOGGER.debug("Country: {}", c));
        LOGGER.info("End: testGetCountriesStartingWith");
    }

}