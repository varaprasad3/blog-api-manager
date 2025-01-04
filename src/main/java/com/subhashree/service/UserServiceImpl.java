package com.subhashree.service;

import java.util.List;
 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhashree.entities.User;
import com.subhashree.exception.ResourceNotFoundException;
import com.subhashree.payload.UserDto;
import com.subhashree.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	public UserDto createUser(UserDto user) {
		User user1=dtoToUser(user);
		User savedUser=repo.save(user1);
		return userToDto(savedUser);
	}

	private User dtoToUser(UserDto user) {
		User user1= new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        user1.setPassword(user.getPassword());
        user1.setCreated_at(user.getDate());
		return user1;
	}

	public UserDto updateUser(UserDto user, Integer userId) {
		User user1=this.repo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setAbout(user.getAbout());
		User updatedUser=repo.save(user1);
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
		    userDto.setAbout(user.getAbout());
		    userDto.setPassword(user.getPassword());
		    userDto.setDate(user.getCreated_at());
		    return userDto;
		}
	}



