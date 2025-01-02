package com.subhashree.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.subhashree.entities.User;
import com.subhashree.exception.ResourceNotFoundException;
import com.subhashree.payload.UserDto;
import com.subhashree.repo.UserRepo;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	public UserDto createUser(UserDto user) {
		User user1=this.dtoToUser(user);
		User savedUser=this.repo.savedUser(user);
		this.repo.savedUser(user);
		return user;
	}

	private User dtoToUser(UserDto user) {
		User user1= new User();
        user.setId(user.getId());
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setAbout(user.getAbout());
		return user1;
	}

	public UserDto updateUser(UserDto user, Integer userId) {
		User user1=this.repo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setAbout(user.getAbout());
		User updatedUser=this.repo.savedUser(user);
		return user;
	}

	public UserDto getUserById(Integer userId) {
		User user=this.repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}
	public List<UserDto> getAllUsers() {
		List<User>users=this.repo.findAll();
		List<UserDto>userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	public void deleteUser(Integer userId) {
		User user=this.repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		this.repo.delete(user);
		
	}
	private UserDto userToDto(User user) {
		
		    UserDto userDto = new UserDto();
		    userDto.setId(user.getId());
		    userDto.setName(user.getName());
		    userDto.setEmail(user.getEmail());
		   
		    return userDto;
		}
	}



