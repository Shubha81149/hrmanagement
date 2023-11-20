package com.example.humanmanagement.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="perform")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @Column(name="name" ,nullable = false)
    private String name;
    @Column(name="dept")
    private String department;
    @Column(name = "grade")
    private String grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
