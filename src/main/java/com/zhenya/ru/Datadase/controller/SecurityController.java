package com.zhenya.ru.Datadase.controller;

import com.zhenya.ru.Datadase.dto.AuthDTO;
import com.zhenya.ru.Datadase.dto.PersonDTO;
import com.zhenya.ru.Datadase.repository.PersonRepository;
import com.zhenya.ru.Datadase.security.JwtUtil;
import com.zhenya.ru.Datadase.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SecurityController {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final SecurityService securityService;


    @PostMapping("/singin")
    ResponseEntity<?> singin(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(securityService.authorize(authDTO.username(),authDTO.password()));

    }
    @PostMapping("/singup")
    ResponseEntity<?> singup(@RequestBody PersonDTO personDTO){
         return ResponseEntity.ok(securityService.register(personDTO.username(), personDTO.email(), personDTO.password()));


    }
}
