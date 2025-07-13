package com.cognizant.jwt.service;

import com.cognizant.jwt.model.Country;
import com.cognizant.jwt.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private List<Country> countryList;

    public CountryService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        countryList = context.getBean("countryList", List.class);
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry");
        Optional<Country> countryOptional = countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (countryOptional.isEmpty()) {
            throw new CountryNotFoundException("Country not found");
        }

        LOGGER.info("END getCountry");
        return countryOptional.get();
    }

    public List<Country> getAllCountries() {
        return countryList;
    }
}