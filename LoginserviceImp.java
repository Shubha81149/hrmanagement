package com.example.humanmanagement.ServiceImplayer;

import com.example.humanmanagement.Loginrepository;
import com.example.humanmanagement.Model.Login;
import com.example.humanmanagement.ResourceNotFoundException;
import com.example.humanmanagement.Servicelayer.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LoginserviceImp implements LoginService {
    private Loginrepository loginrepository;
    @Autowired
    public LoginserviceImp(Loginrepository loginrepository){
        this.loginrepository= loginrepository;
    }
    @Override
    public List<Login>getAllLogin(){
        return loginrepository.findAll();
    }
    @Override
    public  Login getLoginById(Long id){
        Optional<Login> login = loginrepository.findById(id);
        if (login.isPresent()){
            return login.get();
        }else{
            throw new ResourceNotFoundException("Login","id",id);
        }
    }
    @Override
    public Login updateLogin(Login login,Long lgnid){
        Login existingLogin = loginrepository.findById(lgnid).orElseThrow(
                ()-> new ResourceNotFoundException("Login","id",lgnid) );
        existingLogin.setEmail(login.getEmail());
        loginrepository.save(existingLogin);
        return existingLogin;
    }
    @Override
    public  Login deleteLogin(Long id){
        loginrepository.deleteById(id);
        return null;
    }
}
