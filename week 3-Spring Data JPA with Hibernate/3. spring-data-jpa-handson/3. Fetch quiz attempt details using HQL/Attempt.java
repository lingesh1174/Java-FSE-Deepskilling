package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    private int atId;

    private LocalDate atDate;
    private double atScore;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    private Set<AttemptQuestion> attemptQuestions;
    
    public int getAtId() { return atId; }
    public void setAtId(int atId) { this.atId = atId; }

    public LocalDate getAtDate() { return atDate; }
    public void setAtDate(LocalDate atDate) { this.atDate = atDate; }

    public double getAtScore() { return atScore; }
    public void setAtScore(double atScore) { this.atScore = atScore; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Set<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) { this.attemptQuestions = attemptQuestions; }

}
