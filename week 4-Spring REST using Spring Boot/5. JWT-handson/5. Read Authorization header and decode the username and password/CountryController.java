package com.cognizant.jwt.controller;

import com.cognizant.jwt.model.Country;
import com.cognizant.jwt.service.CountryService;
import com.cognizant.jwt.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country addCountry(@Valid @RequestBody Country country) {
        LOGGER.info("Country: {}", country);
        return country;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("GET all countries");
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("GET country with code: {}", code);
        return countryService.getCountry(code);
    }
}