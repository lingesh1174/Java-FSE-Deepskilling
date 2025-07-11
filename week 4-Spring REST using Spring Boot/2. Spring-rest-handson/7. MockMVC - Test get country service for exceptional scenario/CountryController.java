package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia() throws CountryNotFoundException {
        LOGGER.info("START getCountryIndia()");
        Country country = countryService.getCountry("IN");
        LOGGER.info("END getCountryIndia()");
        return country;
    }

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry() with code = {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END getCountry()");
        return country;
    }
}