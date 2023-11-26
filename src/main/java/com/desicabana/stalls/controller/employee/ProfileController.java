package com.desicabana.stalls.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping("/employee/employeeProfile")
    public String showRegistrationPage() {
        return "employeePortal/employeeProfile";
    }
}
