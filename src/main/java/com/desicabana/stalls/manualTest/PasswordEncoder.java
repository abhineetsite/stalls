package com.desicabana.stalls.manualTest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String args[]){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String textualPass = "demo";
        String encodedPassword = "";
        encodedPassword = passwordEncoder.encode(textualPass);
        System.out.println("####"+encodedPassword+"####");
    }
}
