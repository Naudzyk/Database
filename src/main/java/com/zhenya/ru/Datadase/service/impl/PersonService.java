package com.zhenya.ru.Datadase.service.impl;

import com.zhenya.ru.Datadase.models.Person;
import com.zhenya.ru.Datadase.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonService  implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findPersonByUsername(username).orElseThrow(()
        -> new UsernameNotFoundException(String.format("User не найден", username)));

        return PersonDetailsImpl.build(person);
    }
}
