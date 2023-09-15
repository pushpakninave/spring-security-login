package com.aliencode.loginauth.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OathController {

    @GetMapping("/welcome")
    public String getMessage() {
        String msg = "welcome to aliencodes@hashcode";
        return msg;
    }

    @GetMapping("/statement")
    public String getStatement() {
        String statement = "1. Account name: Pushpak Ninave\n2. Account balance : 50000";
        return statement;
    }

    @GetMapping("/loan")
    public String getLoan() {
        String loan = "loan 0f $2500";
        return loan;
    }

    @GetMapping("/contact")
    public String getContact() {
        String contact = "1. mail: bank@gmail.com\n2. ph.no: 0000000000";
        return contact;
    }
}
