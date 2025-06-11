package com.phishing.simulator.controller;

import com.phishing.simulator.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail() {
        String htmlBody= """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                  <title>Sign in – Google accounts</title>
                  <style>
                    body {
                      background-color: #f2f2f2;
                      font-family: "Roboto", sans-serif;
                      margin: 0;
                      padding: 0;
                    }
                
                    .container {
                      max-width: 400px;
                      margin: 60px auto;
                      background-color: #ffffff;
                      box-shadow: 0 2px 8px rgba(0,0,0,0.2);
                      padding: 40px 30px;
                      border-radius: 8px;
                    }
                
                    .logo {
                      display: block;
                      margin: 0 auto 20px;
                      width: 75px;
                    }
                
                    h1 {
                      font-weight: 400;
                      font-size: 24px;
                      margin-bottom: 5px;
                    }
                
                    .subtitle {
                      font-size: 16px;
                      color: #5f6368;
                      margin-bottom: 30px;
                    }
                
                    input[type="email"], input[type="password"] {
                      width: 100%;
                      padding: 14px;
                      font-size: 16px;
                      margin-bottom: 20px;
                      border: 1px solid #dadce0;
                      border-radius: 4px;
                      box-sizing: border-box;
                    }
                
                    .btn {
                      background-color: #1a73e8;
                      color: #fff;
                      border: none;
                      padding: 12px 24px;
                      border-radius: 4px;
                      font-size: 14px;
                      cursor: pointer;
                      float: right;
                    }
                
                    .footer {
                      margin-top: 60px;
                      font-size: 12px;
                      color: #777;
                      text-align: center;
                    }
                
                    .warning {
                      color: red;
                      font-size: 14px;
                      text-align: center;
                      margin-top: 30px;
                      font-weight: bold;
                    }
                  </style>
                </head>
                <body>
                  <div class="container">
                    <img class="logo" src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png" alt="Google Logo">
                    <h1>Sign in</h1>
                    <p class="subtitle">Use your Google Account</p>
                    <form onsubmit="alert('⚠️ This is a phishing simulation. No data is sent.')">
                      <input type="email" placeholder="Email or phone" required>
                      <input type="password" placeholder="Enter your password" required>
                      <button type="submit" class="btn">Next</button>
                    </form>
                
                    <div class="footer">
                      © 2025 Google LLC – Phishing Awareness Simulation
                    </div>
                  </div>
                </body>
                </html>
                """;
        emailService.sendEmail("mail2adityasinghsln@gmail.com", "Test Subject", htmlBody);
        return "Email sent!";
    }
}

