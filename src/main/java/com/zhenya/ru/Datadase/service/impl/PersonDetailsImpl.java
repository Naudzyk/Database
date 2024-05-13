package com.zhenya.ru.Datadase.service.impl;

import com.zhenya.ru.Datadase.models.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
@AllArgsConstructor
public class PersonDetailsImpl implements UserDetails {
    private int id;
    private String username;
    private String email;
    private String password;


    public static UserDetails build(Person person) {
        return new PersonDetailsImpl(
                person.getId(),
                person.getUsername(),
                person.getEmail(),
                person.getPassword());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
