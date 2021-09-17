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

import br.com.training.model.User;
import br.com.training.service.UserService;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody @Valid User user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
    public User getUser (@PathVariable String cpf){
        return userService.getUser(cpf);
    }
	
	@PutMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public User updateUser(@PathVariable String cpf, @RequestBody @Valid User user) {
		return userService.updateUser(cpf , user);
	}
	
	@DeleteMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable String cpf) {
		userService.deleteUser(cpf);
	}

}
