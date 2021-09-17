package br.com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUser(String cpf) {
		return userRepository.findByCpf(cpf);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User updateUser(String cpf , User user) {		
		return userRepository.save(user);
	}
	
	public void deleteUser(String cpf) {
		User user = userRepository.findByCpf(cpf);
		userRepository.delete(user);
	}

}
