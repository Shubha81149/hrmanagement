package com.example.humanmanagement.Controllerlayer;

import com.example.humanmanagement.Model.Login;
import com.example.humanmanagement.Servicelayer.LoginService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lgn")
public class LoginControl {
    private LoginService loginService;

    @Autowired
    public LoginControl(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping
    public List<Login>getAllLogin(){
        return loginService.getAllLogin();
    }
    @GetMapping("{id}")
    public ResponseEntity<Login>getlgn(@PathVariable("id")Long lgnid){
        return  new ResponseEntity<Login>(loginService.getLoginById(lgnid), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String>updateLogin(@RequestBody Login login, @PathVariable("id")Long lgnid){
        loginService.updateLogin(login,lgnid);
        return new ResponseEntity<String>("Update successfull",HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Login>deleteLogin(@PathVariable("id")Long lgnid){
        return  new ResponseEntity<Login>(loginService.deleteLogin(lgnid),HttpStatus.OK);
    }

}
