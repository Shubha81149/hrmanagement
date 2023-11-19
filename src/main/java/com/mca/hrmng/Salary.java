package com.mca.hrmng;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "slry")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "dptm")
    private String dptm;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "complain")
    private String complain;

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

    public String getDptm() {
        return dptm;
    }

    public void setDptm(String dptm) {
        this.dptm = dptm;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }
}
