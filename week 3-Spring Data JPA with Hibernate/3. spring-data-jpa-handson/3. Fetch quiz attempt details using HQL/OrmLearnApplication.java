package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Attempt attempt = attemptService.getAttempt(1, 1);

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            System.out.println(aq.getQuestion().getQtText());

            for (AttemptOption ao : aq.getAttemptOptions()) {
                Option op = ao.getOption();
                System.out.printf(" %d) %-10s %.1f\t%s\n",
                        op.getOpId(), op.getOpText(), op.getOpScore(), ao.isAoSelected());
            }
            System.out.println();
        }
    }
}