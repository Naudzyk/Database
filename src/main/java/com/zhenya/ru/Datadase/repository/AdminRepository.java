package com.zhenya.ru.Datadase.repository;

import com.zhenya.ru.Datadase.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Person,Integer> {
    Optional<Person> deletePersonById (Integer id);
}
