package com.desicabana.stalls.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/employee/login")
    public String showLoginPage() {
        return "employeePortal/login";
    }
}
