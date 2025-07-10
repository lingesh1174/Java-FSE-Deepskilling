package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    private int usId;

    private String usName;
    private String usEmail;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Attempt> attempts;
    
    public int getUsId() { return usId; }
    public void setUsId(int usId) { this.usId = usId; }

    public String getUsName() { return usName; }
    public void setUsName(String usName) { this.usName = usName; }

    public String getUsEmail() { return usEmail; }
    public void setUsEmail(String usEmail) { this.usEmail = usEmail; }

    public List<Attempt> getAttempts() { return attempts; }
    public void setAttempts(List<Attempt> attempts) { this.attempts = attempts; }
}
