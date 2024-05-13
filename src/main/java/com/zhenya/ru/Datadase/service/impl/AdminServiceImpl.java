package com.zhenya.ru.Datadase.service.impl;

import com.zhenya.ru.Datadase.models.Person;
import com.zhenya.ru.Datadase.repository.AdminRepository;
import com.zhenya.ru.Datadase.repository.PersonRepository;
import com.zhenya.ru.Datadase.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final PersonRepository personRepository;
    private final AdminRepository adminRepository;

    @Override
    public List<Person> showAllUser() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> delete(Integer id) {
        return adminRepository.deletePersonById(id);
    }


}
