package com.zhenya.ru.Datadase.controller;

import com.zhenya.ru.Datadase.service.impl.PersonDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user")
@RestController
public class PersonController {
    @GetMapping("/getId")
    @ResponseBody
    public int id(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetailsImpl personDetails = (PersonDetailsImpl) authentication.getPrincipal();
        return personDetails.getId();
    }

    @GetMapping("/info")
    public String info(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetailsImpl personDetails = (PersonDetailsImpl) authentication.getPrincipal();
        return personDetails.getUsername();
    }
}
