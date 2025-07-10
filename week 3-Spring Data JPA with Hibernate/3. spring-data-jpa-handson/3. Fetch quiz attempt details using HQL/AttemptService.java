package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    public Attempt getAttempt(int userId, int attemptId) {
        return attemptRepository.getAttempt(userId, attemptId);
    }
}
