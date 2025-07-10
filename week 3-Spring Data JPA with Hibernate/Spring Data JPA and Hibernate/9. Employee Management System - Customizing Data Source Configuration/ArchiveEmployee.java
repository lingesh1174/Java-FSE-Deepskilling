package com.cognizant.employee.secondary.model;

import jakarta.persistence.*;

@Entity
@Table(name = "archive_employee")
public class ArchiveEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "archived_name")
    private String archivedName;

    public ArchiveEmployee() {}

    public ArchiveEmployee(String archivedName) {
        this.archivedName = archivedName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArchivedName() {
        return archivedName;
    }

    public void setArchivedName(String archivedName) {
        this.archivedName = archivedName;
    }

    @Override
    public String toString() {
        return "ArchiveEmployee{" +
                "id=" + id +
                ", archivedName='" + archivedName + '\'' +
                '}';
    }
}
