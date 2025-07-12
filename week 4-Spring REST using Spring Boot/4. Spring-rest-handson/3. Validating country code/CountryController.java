package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @PostMapping("/countries")
    @ResponseStatus(HttpStatus.CREATED)
    public Country addCountry(@Valid @RequestBody Country country) {
        LOGGER.info("Country: {}", country);
        return country;
    }
}