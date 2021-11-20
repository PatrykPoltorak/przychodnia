package com.example.przychodnia.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.przychodnia.entity.Users;
import com.example.przychodnia.entity.Role;
import com.example.przychodnia.repository.*;
import java.util.Set;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HomeController {
	private final VisitRepository visitRepository;
	private final UsersRepository usersRepository;
	private final RoleRepository roleRepository;	
	public HomeController( VisitRepository visitRepository, UsersRepository usersRepository,
			RoleRepository roleRepository) {		
		this.visitRepository = visitRepository;
		this.usersRepository = usersRepository;
		this.roleRepository = roleRepository;		
	}
	@GetMapping("/home")
	public String home(Model model,@AuthenticationPrincipal UserDetails customUser){
		String username=customUser.getUsername();
		Set<Role> role = usersRepository.findByUsername(username).getRoles();
		Users users = usersRepository.findByUsername(username);
		Role adminRole=roleRepository.findByName("ROLE_ADMIN");
        Role doctorRole=roleRepository.findByName("ROLE_DOCTOR");
        Role receptionRole=roleRepository.findByName("ROLE_RECEPTION"); 
        if(role.contains(adminRole)) {
        	model.addAttribute("role", adminRole);
        	model.addAttribute("visit", visitRepository.findAll());
        }else if(role.contains(doctorRole)) {
        	model.addAttribute("role", doctorRole);
        	model.addAttribute("visit", visitRepository.findAllVisitForDoctor(users.getId()));
        }else if(role.contains(receptionRole))
        {	model.addAttribute("role", receptionRole);
        	model.addAttribute("visit", visitRepository.findAll());
        }
		return "home";
	}	
}