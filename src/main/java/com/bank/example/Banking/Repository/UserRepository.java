package com.bank.example.Banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.example.Banking.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
