package com.alone.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getInfo(HttpServletRequest req, Model model) {
        String sessionId = req.getRequestedSessionId();
        CsrfToken csrfToken = (CsrfToken) req.getAttribute("_csrf");
       return "session: "+sessionId+" CSRF: "+csrfToken ; 
    }
    
   
}
