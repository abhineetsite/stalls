package com.desicabana.stalls.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeRegistrationController {
    @GetMapping("/employee/registration")
    public String showRegistrationPage() {
        return "employeePortal/registration";
    }
}
