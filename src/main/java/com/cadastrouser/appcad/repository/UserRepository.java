package com.cadastrouser.appcad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrouser.appcad.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
