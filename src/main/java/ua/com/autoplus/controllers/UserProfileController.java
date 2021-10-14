package ua.com.autoplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.autoplus.entity.Account;
import ua.com.autoplus.services.impl.AccountServiceImpl;

@RestController
public class UserProfileController {

    @Autowired
    private AccountServiceImpl customerService;

    @GetMapping(value = "/api/users/user/{id}",produces = "application/json")
    public Account getUserDetail(@PathVariable Integer id){
        return customerService.findById(id);
    }
}
