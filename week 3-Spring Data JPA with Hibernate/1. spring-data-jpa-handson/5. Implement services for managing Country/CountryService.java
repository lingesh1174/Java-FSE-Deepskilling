package com.cognizant.orm_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

   /* @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }*/
    
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        return countryRepository.findById(countryCode)
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + countryCode + " not found"));
    }
 
    /*@Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }*/
    
    /*@Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Country country = countryRepository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + code + " not found"));

        country.setName(newName);
        countryRepository.save(country);
    }*/
    
    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        if (!countryRepository.existsById(code)) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        countryRepository.deleteById(code);
    }

}