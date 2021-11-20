package com.example.przychodnia.controller;

import java.time.LocalDate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.przychodnia.Service.VisitService;
import com.example.przychodnia.entity.Role;
import com.example.przychodnia.entity.Users;
import com.example.przychodnia.entity.Visit;
import com.example.przychodnia.repository.RoleRepository;
import com.example.przychodnia.repository.UsersRepository;
import com.example.przychodnia.repository.VisitRepository;

@Controller
@RequestMapping("/visit")
public class VisitController {

	private final VisitService visitService;
	private final VisitRepository visitRepository;
	private final UsersRepository usersRepository;
	private final RoleRepository roleRepository;
	public VisitController(VisitService visitService, VisitRepository visitRepository,
			UsersRepository usersRepository,RoleRepository roleRepository) {
		this.visitService = visitService;
		this.visitRepository = visitRepository;
		this.usersRepository = usersRepository;
		this.roleRepository = roleRepository;
	}	
	@GetMapping("visitForPatient")
	public String showVisitForPatient(Model model, @RequestParam("id") int id){
		model.addAttribute("visit", visitRepository.findVisitById(id));
		return "visit-for-patient";
	}
	@PostMapping("/visitForPatient")
	public String showVisitForPatient(@ModelAttribute Visit visit){
		visitService.save(visit);
		return "redirect:/home";
	}
	@GetMapping("/visitForPatient/allVisit")
	public String showAllVisitForPatient(Model model, @RequestParam("id") int id,@RequestParam("visitid") int visitid){
		model.addAttribute("visit", visitRepository.findAllVisitForPatient(id));
		model.addAttribute("visitid", visitid);
		return "all-visit-for-patient";
	}
	@GetMapping("/today")
	public String todayVisitForDoctor(Model model, @AuthenticationPrincipal UserDetails customUser) {
		System.out.println(LocalDate.now().toString());
		String username=customUser.getUsername();
		Users users = usersRepository.findByUsername(username);
		model.addAttribute("visit", visitRepository.findAllVisitForDoctor(users.getId(),LocalDate.now().toString()));
		return "home";	
	}
}
