package com.auth._dbAuth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @GetMapping("/homepage")
    public String homepagePage(){
        return "homepage";
    }


     @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password,@RequestParam String role){
         User user=new User();
         user.setUsername(username);
         user.setPassword(new BCryptPasswordEncoder(12).encode(password));
         user.setRole(role);
         userRepo.save(user);
         return "redirect:/login";
     }

     @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response){
         User user=userRepo.findByUsername(username)
                 .orElseThrow(()->new UsernameNotFoundException("User name Not Found!"));

         if(new BCryptPasswordEncoder().matches(password,user.getPassword())){
             System.out.println("authorised ss");
//             Cretae JWT
             String token=JwtUtil.generateToken(user);
//             SET COOKIE
             Cookie cookie=new Cookie("JWT",token);
             cookie.setMaxAge(3600);
             cookie.setHttpOnly(true);
             response.addCookie(cookie);

             return "redirect:/homepage";
         }else{
             return "redirect:/login?error";
         }

     }


}
