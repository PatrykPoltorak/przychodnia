package com.example.przychodnia.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@NotNull
	@Size(min=2, max=60)
	private String username;
	@NotNull
	@Size(min=2, max=60)
	private String password;
	@NotNull
	@Size(min=2, max=60)
	private String name;
	@NotNull
	@Size(min=2, max=60)
	private String surname;
	@OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
	private List<Visit> usertVisit;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public List<Visit> getUsertVisit() {
		return usertVisit;
	}
	public void setUsertVisit(List<Visit> usertVisit) {
		this.usertVisit = usertVisit;
	}
}