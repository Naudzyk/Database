package com.zhenya.ru.Datadase.controller;

import com.zhenya.ru.Datadase.models.Person;
import com.zhenya.ru.Datadase.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Person>> showAllPerson(){
        List<Person> allPerson = adminService.showAllUser();
        return ResponseEntity.ok(allPerson);
    }




}
