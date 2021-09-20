package br.com.training.dto.request;

import java.time.LocalDate;

import br.com.training.model.User;

public class UserForm {

	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;

	public UserForm(String name, String email, String cpf, LocalDate birthDate) {
		super();
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public User build() {
		User user = new User(this.name, this.email, this.cpf, this.birthDate);
		return user;
	}

}
