package com.example.przychodnia.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.przychodnia.Service.UsersService;
import com.example.przychodnia.entity.Role;
import com.example.przychodnia.entity.Users;
import com.example.przychodnia.repository.*;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UsersRepository usersRepository;	
	private final RoleRepository roleRepository;
	private final UsersService usersService;
	private final VisitRepository visitRepository;
	
	public UserController(UsersRepository usersRepository,
			RoleRepository roleRepository, UsersService usersService, VisitRepository visitRepository) {
		this.usersRepository = usersRepository;
		this.roleRepository = roleRepository;
		this.usersService = usersService;
		this.visitRepository = visitRepository;
	}
	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("users", new Users());
		model.addAttribute("role", roleRepository.findAll());
		return "add-user";
	}
	@PostMapping("/add")
	public String addUser(@Valid @ModelAttribute("users") Users users, BindingResult result,Model model){			
		Users userName = usersRepository.findByUsername(users.getUsername());
		if(result.hasErrors()) {
			System.out.print("error");
			model.addAttribute("role", roleRepository.findAll());
			return "add-user";
		}
		if(userName != null) {
			model.addAttribute("registrationError", "Podana nazwa użytkownika już istnieje");
			model.addAttribute("role", roleRepository.findAll());
			return "add-user";
		}
		usersService.saveUser(users);
		return "redirect:/home";				
	}
	@GetMapping("/doctors")
	public String showDoctor(Model model) {
		Role doctorRole = roleRepository.findByName("ROLE_DOCTOR");
		List<Users> users = usersRepository.findAll().stream().filter(u ->u.getRoles().contains(doctorRole)).collect(Collectors.toList());
		model.addAttribute("users", users);
		return "show-doctor";
	}
	@GetMapping("/visitForDoctor")
	public String showVisitForDoctor(@RequestParam("id") int id, Model model) {
		model.addAttribute("visit", visitRepository.findAllVisitForDoctor(id));
		return "show-visit-for-doctor";
	}
}