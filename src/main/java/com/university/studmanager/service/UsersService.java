package com.university.studmanager.service;

import com.university.studmanager.domain.Users;
import com.university.studmanager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository userRepository;

    @Autowired
    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users addUser(Users user) {
        return userRepository.save(user);
    }

}
