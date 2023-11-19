package com.mca.hrmng;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recruit")
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dept",nullable = false)
    private String department;
    @Column(name = "post")
    private String post;
    @Column(name = "examtime")
    private String examtime;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "interView")
    private String interView;
    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getExamtime() {
        return examtime;
    }

    public void setExamtime(String examtime) {
        this.examtime = examtime;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getInterView() {
        return interView;
    }

    public void setInterView(String interView) {
        this.interView = interView;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
