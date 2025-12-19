package com.ecotrip.ecotrip_backend.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendOtp(String email, String otp) {
        // For testing, just print OTP in console
        System.out.println("OTP sent to " + email + ": " + otp);

        // In real application: integrate SMTP / Gmail / SendGrid
    }
}
