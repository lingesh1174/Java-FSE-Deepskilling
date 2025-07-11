package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.spring_learn.model.Country;
import java.util.ArrayList;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
    	SpringApplication.run(SpringLearnApplication.class, args);
   	    displayCountry();
   	    displayCountries();
    }

    public static void displayCountry() {
        LOGGER.info("START displayCountry");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country inCountry = context.getBean("in", Country.class);
        Country usCountry = context.getBean("us", Country.class);
        Country deCountry = context.getBean("de", Country.class);
        Country jpCountry = context.getBean("jp", Country.class);
        LOGGER.debug("Country : {}", inCountry);
        LOGGER.debug("Country : {}", usCountry);
        LOGGER.debug("Country : {}", deCountry);
        LOGGER.debug("Country : {}", jpCountry);

        LOGGER.info("END displayCountry");
    }

    public static void displayCountries() {
        LOGGER.info("START displayCountries");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);

        for (Country country : countryList) {
            LOGGER.debug("Country : {}", country);
        }

        LOGGER.info("END displayCountries");
    }

}