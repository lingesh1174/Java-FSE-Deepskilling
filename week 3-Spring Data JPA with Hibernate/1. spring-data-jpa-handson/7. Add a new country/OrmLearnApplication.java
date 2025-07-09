package com.cognizant.orm_learn;

import java.util.List;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

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
        //testGetAllCountries();
        
        testAddCountry();
        
        /*try {
        	testFindCountryByCode();
    	} catch (CountryNotFoundException e) {
        	LOGGER.error("Country not found: " + e.getMessage());
    	}*/
    
    }

    /*private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }*/
    
    /*private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End");
    }*/
    
        private static void testAddCountry() {
            LOGGER.info("Start");

            Country newCountry = new Country();
            newCountry.setCode("XY");
            newCountry.setName("Xyloland");

            countryService.addCountry(newCountry);

            try {
                Country savedCountry = countryService.findCountryByCode("XY");
                LOGGER.debug("Added Country: {}", savedCountry);
            } catch (CountryNotFoundException e) {
                LOGGER.error("Country not found after add: " + e.getMessage());
            }

            LOGGER.info("End");
        }
}