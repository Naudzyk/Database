package com.zhenya.ru.Datadase.service;

import com.zhenya.ru.Datadase.models.Person;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Person> showAllUser();

    Optional<Person> delete(Integer id);
}
