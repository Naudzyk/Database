package com.zhenya.ru.Datadase.repository;

import com.zhenya.ru.Datadase.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findPersonByUsername(String username);

    Boolean existsPersonByEmail(String email);

    Boolean existsPersonByUsername(String username);

   Person getPersonById (int id);



}
