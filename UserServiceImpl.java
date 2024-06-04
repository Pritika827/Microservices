package com.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entities.User;
import com.user.exception.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server!!:" + userId));
	}

	@Override
	public void deleteUser(String userId) {
		User user = this.userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not fount on server!!:" + userId));
		this.userRepository.delete(user);
	}

	@Override
	public User updateUser(User user, String userId) {
		User user2 = this.userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server!!:" + userId));
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setAbout(user.getAbout());

		User updatedUser = this.userRepository.save(user2);
		return updatedUser;
	}

}
