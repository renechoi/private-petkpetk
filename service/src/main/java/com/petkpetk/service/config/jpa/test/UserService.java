package com.petkpetk.service.config.jpa.test;// package com.petkpetk.service.config.jpa.test;
//
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Service;
//
// @Service
// public class UserService {
//     private final UserRepository userRepository;
//
//     public UserService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }
//
//     @Transactional
//     public void registerUser(RegisterRequest registerRequest) {
//         User user = new User();
//         user.setUsername(registerRequest.getUsername());
//         user.setPassword(registerRequest.getPassword());
//         user.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
//         userRepository.save(user);
//     }
// }
