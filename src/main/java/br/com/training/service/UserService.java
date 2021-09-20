package br.com.training.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.dto.request.UserForm;
import br.com.training.dto.response.UserResponse;
import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserResponse createUser(UserForm userForm) {
		return transformUserDTO(userRepository.save(userForm.build()));
	}
	
	public UserResponse getUser(String cpf) {
		return transformUserDTO(userRepository.findByCpf(cpf));
	}
	
	public List<UserResponse> getAllUsers(){
		return userRepository.findAll().stream().map(this::transformUserDTO).collect(Collectors.toList());
	}
	
	public UserResponse updateUser(String cpf , UserForm userForm) {		
		return transformUserDTO(userRepository.save(userForm.build()));
	}
	
	public void deleteUser(String cpf) {
		userRepository.delete(userRepository.findByCpf(cpf));
	}
	
	private UserResponse transformUserDTO(User user) {
		return new UserResponse(user.getName(), user.getEmail(), user.getCpf(), user.getBirthDate());
	}
	

}
