package ua.com.autoplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.autoplus.entity.Account;
import ua.com.autoplus.services.AccountService;
import ua.com.autoplus.services.SecurityService;

@RestController
public class TokenController {

    @Autowired
    private AccountService customerService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/api/token")
    public Account getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        return customerService.login(username,password);
    }

    @PostMapping("/api/registration")
    public Account registration(@RequestParam("username") final String username, @RequestParam("email") final String email, @RequestParam("phone") final String phone, @RequestParam("password") final String password){
        Account account = customerService.save(username, password, email, phone);
        securityService.autoLogin(username, password);
        return account;
    }
}