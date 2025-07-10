package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {
    @Id
    private int aqId;

    @ManyToOne
    @JoinColumn(name = "aq_at_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qt_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.LAZY)
    private Set<AttemptOption> attemptOptions;
    
    public int getAqId() { return aqId; }
    public void setAqId(int aqId) { this.aqId = aqId; }

    public Attempt getAttempt() { return attempt; }
    public void setAttempt(Attempt attempt) { this.attempt = attempt; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public Set<AttemptOption> getAttemptOptions() { return attemptOptions; }
    public void setAttemptOptions(Set<AttemptOption> attemptOptions) { this.attemptOptions = attemptOptions; }
}