package com.educandoweb.demo.repositories;

import com.educandoweb.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
