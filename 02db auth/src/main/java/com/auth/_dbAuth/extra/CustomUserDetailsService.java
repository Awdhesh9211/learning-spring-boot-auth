//package com.auth._dbAuth;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        System.out.println("Hi I am called");
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }else{
//            return new CustomeUserDetails(user);
//        }
//
//        // Convert your User entity to Spring Security's UserDetails
////        return new org.springframework.security.core.userdetails.User(
////                user.getUsername(),
////                user.getPassword(),
////                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
////        );
//    }
//}
