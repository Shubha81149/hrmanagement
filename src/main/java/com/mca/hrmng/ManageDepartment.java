package com.mca.hrmng;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "md")
public class ManageDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "vacancy")
    private Integer vacancy;
    @Column(name = "totalDept")
    private Integer totalDept;

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

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    public Integer getTotalDept() {
        return totalDept;
    }

    public void setTotalDept(Integer totalDept) {
        this.totalDept = totalDept;
    }
}
