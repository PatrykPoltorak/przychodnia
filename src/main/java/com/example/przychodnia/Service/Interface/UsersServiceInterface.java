package com.example.przychodnia.Service.Interface;



import com.example.przychodnia.entity.Users;

public interface UsersServiceInterface {
	void saveUser(Users users);
	void delateUserByID(int id);
	void editUser(Users users);
	Users findByUserName(String name);
}
