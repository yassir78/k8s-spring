package com.fstg.bookeraccountservice.infra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bookeraccountservice.infra.entity.User;

import java.util.Optional;


@Repository
public interface UserDao  extends JpaRepository<User, Long>{
	   User findByUsername(String username);
       int deleteByUsername(String username);
       boolean existsByRef(String ref);
       Optional<User> findByRef(String ref);
       User findByEmail(String email);

}
