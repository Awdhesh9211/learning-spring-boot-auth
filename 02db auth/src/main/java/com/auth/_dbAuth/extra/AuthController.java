//package com.auth._dbAuth;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private UserService userService;
//
//    // Show login page
//    @GetMapping("/login")
//    public String showLoginPage() {
//        return "login";
//    }
//
//    // Handle login
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpServletResponse response) {
//
//
//        try {
//
////            Authentication authentication = authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(username,password)
////            );
//            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//            System.out.println("Authentication Token: " + token); // Add this line
//            Authentication authentication = authenticationManager.authenticate(token);
//
//
//
//            // If authentication is successful, generate JWT token
//            String jwt = jwtUtil.generateToken(username);
//            Cookie cookie = new Cookie("jwt", jwt);
//            cookie.setHttpOnly(true);
//            cookie.setPath("/"); // Set path according to your needs
//            cookie.setMaxAge(10 * 60 * 60); // 10 hours in seconds
//            response.addCookie(cookie);
//
//            return "redirect:/homepage";
//        } catch (AuthenticationException e) {
//            // Handle authentication failure
//            return "redirect:/login?error";
//        }
//    }
//
//    // Show registration page
//    @GetMapping("/register")
//    public String showRegisterPage() {
//        return "register";
//    }
//
//    // Handle registration
//    @PostMapping("/register")
//    public String register(@RequestParam String username,
//                           @RequestParam String password,@RequestParam String role) {
//        userService.registerUser(new User(username, password,role));
//        return "redirect:/login";
//    }
//
//    // Show homepage
//    @GetMapping("/homepage")
//    public String homepage() {
//        return "homepage";
//    }
//}
