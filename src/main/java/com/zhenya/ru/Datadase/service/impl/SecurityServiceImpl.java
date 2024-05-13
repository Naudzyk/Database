package com.zhenya.ru.Datadase.service.impl;

import com.zhenya.ru.Datadase.dto.TokenDTO;
import com.zhenya.ru.Datadase.exception.InvalidCredentialsException;
import com.zhenya.ru.Datadase.exception.NotValidArgumentException;
import com.zhenya.ru.Datadase.models.Person;
import com.zhenya.ru.Datadase.repository.PersonRepository;
import com.zhenya.ru.Datadase.secutity.JwtUtil;
import com.zhenya.ru.Datadase.service.SecurityService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class SecurityServiceImpl implements SecurityService {
    private final PersonRepository personRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public SecurityServiceImpl(PersonRepository personRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Person register(String username, String email, String password) {
        if (username == null || password == null || email == null|| username.isEmpty() || password.isEmpty() || email.isEmpty()|| username.isBlank() || password.isBlank() || email.isBlank()) {
            throw new NotValidArgumentException("Пароль или логин или email не могут быть пустыми или состоять только из пробелов.");
        }
        if (password.length() < 5 || password.length() > 30) {
            throw new NotValidArgumentException("Длина пароля должна составлять от 5 до 30 символов.");
        }
        if(personRepository.existsPersonByUsername(username)){
            throw new SecurityException("Такой пользователь уже есть");
        }

        String passwordhashed = passwordEncoder.encode(password);
        Person person = new Person();
        person.setUsername(username);
        person.setEmail(email);
        person.setPassword(passwordhashed);

        person.setRole_user("USER");

         return personRepository.save(person);
    }

    @Override
    public TokenDTO authorize(String username, String password) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Неправильный пароль или имя");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateToken(authentication);
        return new TokenDTO(jwt);
    }
}
