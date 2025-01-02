package com.subhashree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subhashree.entities.User;
import com.subhashree.payload.UserDto;

public interface UserRepo extends JpaRepository<User, Integer>{
	User savedUser(UserDto user);


}
