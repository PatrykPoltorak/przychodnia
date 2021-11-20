package com.example.przychodnia.Service;


import org.springframework.stereotype.Service;

import com.example.przychodnia.Service.Interface.UsersServiceInterface;
import com.example.przychodnia.entity.Users;
import com.example.przychodnia.repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsersService implements UsersServiceInterface {
	private UsersRepository usersRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UsersService(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
		this.usersRepository = usersRepository;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public void delateUserByID(int id) {
		usersRepository.deleteById(id);	
	}
	@Override
	public void editUser(Users user) {
		usersRepository.save(user);	
	}
	@Override
	public Users findByUserName(String name) {		
		return usersRepository.findByUsername(name);
	}
    @Override
    public void saveUser(Users users) {
		users.setPassword(passwordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
    }	
}