package com.educandoweb.demo.services;

import com.educandoweb.demo.entities.User;
import com.educandoweb.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User FindById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
