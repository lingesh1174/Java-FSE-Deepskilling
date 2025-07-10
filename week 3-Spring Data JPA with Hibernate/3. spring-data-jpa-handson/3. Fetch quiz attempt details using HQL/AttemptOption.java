package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {
    @Id
    private int aoId;

    private boolean aoSelected;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private Option option;

    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;
    
    public int getAoId() { return aoId; }
    public void setAoId(int aoId) { this.aoId = aoId; }

    public boolean isAoSelected() { return aoSelected; }
    public void setAoSelected(boolean aoSelected) { this.aoSelected = aoSelected; }

    public Option getOption() { return option; }
    public void setOption(Option option) { this.option = option; }

    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public void setAttemptQuestion(AttemptQuestion attemptQuestion) { this.attemptQuestion = attemptQuestion; }
}
