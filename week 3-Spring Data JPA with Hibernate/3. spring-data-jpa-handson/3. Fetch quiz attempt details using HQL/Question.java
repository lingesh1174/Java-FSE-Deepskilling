package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    private int qtId;

    private String qtText;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Option> options;
    
    public int getQtId() { return qtId; }
    public void setQtId(int qtId) { this.qtId = qtId; }

    public String getQtText() { return qtText; }
    public void setQtText(String qtText) { this.qtText = qtText; }

    public List<Option> getOptions() { return options; }
    public void setOptions(List<Option> options) { this.options = options; }
}