package br.com.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.training.dto.request.UserForm;
import br.com.training.dto.response.UserResponse;
import br.com.training.service.UserService;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponse createUser(@RequestBody @Valid UserForm userForm) {
		return userService.createUser(userForm);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserResponse> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
    public UserResponse getUser (@PathVariable String cpf){
        return userService.getUser(cpf);
    }
	
	@PutMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse updateUser(@PathVariable String cpf, @RequestBody @Valid UserForm userForm) {
		return userService.updateUser(cpf , userForm);
	}
	
	@DeleteMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable String cpf) {
		userService.deleteUser(cpf);
	}

}
