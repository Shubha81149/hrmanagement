package com.example.humanmanagement.Servicelayer;

import com.example.humanmanagement.Model.Login;

import java.util.List;

public interface LoginService {
    List<Login> getAllLogin();
    Login getLoginById(Long id);
    Login updateLogin(Login login,Long lgnid);
    Login deleteLogin(Long id);
}
