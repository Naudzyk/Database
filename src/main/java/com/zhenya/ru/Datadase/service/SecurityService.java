package com.zhenya.ru.Datadase.service;

import com.zhenya.ru.Datadase.dto.TokenDTO;
import com.zhenya.ru.Datadase.models.Person;

public interface SecurityService {

    Person register ( String username,String email,String password);

    TokenDTO authorize(String username, String password);
}
