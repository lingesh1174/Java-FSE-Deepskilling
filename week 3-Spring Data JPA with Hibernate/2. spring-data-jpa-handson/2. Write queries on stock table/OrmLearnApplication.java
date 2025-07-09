package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static StockRepository stockRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        stockRepository = context.getBean(StockRepository.class);

        testStockQueries();
    }

    private static void testStockQueries() {
        LOGGER.info("Start");

        List<Stock> fbStocks = stockRepository.findByCodeAndDateBetween(
                "FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        fbStocks.forEach(s -> LOGGER.debug("FB Sept 2019: {}", s));

        List<Stock> googlStocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        googlStocks.forEach(s -> LOGGER.debug("GOOGL > 1250: {}", s));

        List<Stock> topVolume = stockRepository.findTop3ByOrderByVolumeDesc();
        topVolume.forEach(s -> LOGGER.debug("Top Volume: {}", s));

        List<Stock> lowNetflix = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        lowNetflix.forEach(s -> LOGGER.debug("Lowest NFLX: {}", s));

        LOGGER.info("End");
    }
}
