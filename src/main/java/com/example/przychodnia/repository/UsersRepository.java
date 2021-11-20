package com.example.przychodnia.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.przychodnia.entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	@Query("select u from Users u where u.id=?1")
	Users findUserById(int id);
	Users findByUsername(String username);
}
