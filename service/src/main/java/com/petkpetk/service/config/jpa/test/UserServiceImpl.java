package com.petkpetk.service.config.jpa.test;// package com.petkpetk.service.config.jpa.test;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AnonymousAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Service;
//
// @Service
// public class UserServiceImpl implements UserService {
//
//     private final UserRepository userRepository;
//
//     @Autowired
//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }
//
//     @Override
//     public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
//
//         if (emailExists(userDto.getEmail())) {
//             throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getEmail());
//         }
//
//         User user = new User();
//         user.setFirstName(userDto.getFirstName());
//         user.setLastName(userDto.getLastName());
//         user.setEmail(userDto.getEmail());
//         user.setPassword(userDto.getPassword());
//
//         // Set createdBy value using AnonymousAuthenticationToken's name
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         if (authentication instanceof AnonymousAuthenticationToken) {
//             AnonymousAuthenticationToken anonymousAuthenticationToken = (AnonymousAuthenticationToken) authentication;
//             user.setCreatedBy(anonymousAuthenticationToken.getName());
//         }
//
//         return userRepository.save(user);
//     }
//
//     private boolean emailExists(String email) {
//         return userRepository.findByEmail(email) != null;
//     }
// }
