package com.capg.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.user.entity.Users;
import com.capg.user.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    // SAVE USER
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    // FIND USER BY ID
    public Users getUser(int id) {
        return usersRepository.findById(id).orElse(null);
    }
}
