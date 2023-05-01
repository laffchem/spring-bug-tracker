package com.jlaffey.bugtrackersite.services;

import com.jlaffey.bugtrackersite.models.UserEntity;
import com.jlaffey.bugtrackersite.dtos.RegistrationDto;


public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
