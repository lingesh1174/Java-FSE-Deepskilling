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

    @Transactional
    public List<Country> getCountriesByPartialName(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Transactional
    public List<Country> getCountriesByPartialNameSorted(String keyword) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(keyword);
    }

    @Transactional
    public List<Country> getCountriesStartingWith(String letter) {
        return countryRepository.findByNameStartingWithIgnoreCase(letter);
    }

}