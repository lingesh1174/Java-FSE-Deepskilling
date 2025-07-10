package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Option {
    @Id
    private int opId;

    private String opText;
    private double opScore;

    @ManyToOne
    @JoinColumn(name = "op_qt_id")
    private Question question;
    
    public int getOpId() { return opId; }
    public void setOpId(int opId) { this.opId = opId; }

    public String getOpText() { return opText; }
    public void setOpText(String opText) { this.opText = opText; }

    public double getOpScore() { return opScore; }
    public void setOpScore(double opScore) { this.opScore = opScore; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}
