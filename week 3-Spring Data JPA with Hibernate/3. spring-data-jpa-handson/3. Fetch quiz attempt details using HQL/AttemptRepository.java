package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("SELECT a FROM Attempt a " +
           "JOIN FETCH a.user u " +
           "JOIN FETCH a.attemptQuestions aq " +
           "JOIN FETCH aq.question q " +
           "JOIN FETCH aq.attemptOptions ao " +
           "JOIN FETCH ao.option o " +
           "WHERE u.usId = :userId AND a.atId = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
