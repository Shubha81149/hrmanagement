package com.example.humanmanagement;


import com.example.humanmanagement.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Loginrepository extends JpaRepository<Login,Long> {
}
