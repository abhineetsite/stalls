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
// Compare this snippet from src/main/java/com/desicabana/stalls/controller/employee/ProfileController.java:
/* @Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "profile";
    }
} */