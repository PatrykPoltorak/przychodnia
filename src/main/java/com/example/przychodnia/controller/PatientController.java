package com.example.przychodnia.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.przychodnia.Service.PatientService;
import com.example.przychodnia.Service.VisitService;
import com.example.przychodnia.entity.*;
import com.example.przychodnia.repository.*;
import org.springframework.validation.BindingResult;
@Controller
@RequestMapping("/patient")
public class PatientController {
	private final PatientRepository patientRepository;
	private final PatientService patientService;
	private final UsersRepository usersRepository;
	private final RoleRepository roleRepository;
	private final VisitService visitService;
	private final VisitRepository visitRepository;
	private final DatesRepository datesRepository;
	
	public PatientController(PatientRepository patientRepository,
			PatientService patientService, UsersRepository usersRepository,
			RoleRepository roleRepository,VisitService visitService, VisitRepository visitRepository,
			DatesRepository datesRepository) {
		this.patientService = patientService;
		this.patientRepository = patientRepository;
		this.usersRepository = usersRepository;
		this.roleRepository = roleRepository;
		this.visitService = visitService;
		this.visitRepository = visitRepository;
		this.datesRepository = datesRepository;
	}
	@GetMapping("")
	public String showPatient(Model model) {
		model.addAttribute("patients",patientRepository.findAll());
		return "show-patients";
	}
	@GetMapping("/add")
	public String addPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "add-patient";
	}
	@PostMapping("/add")
	public String addPatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result) {
		if(result.hasErrors()) {
			return "add-patient";
		}
		patientService.savePatient(patient);
		return "redirect:/patient";
	}
	@GetMapping("/edit")
	public String editPatient(Model model, @RequestParam("id") int id) {
		model.addAttribute("patient",patientRepository.findPatientById(id));
		return "edit-patient";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute Patient patient) {
		patientService.edit(patient);
		return "redirect:/patient";
	}
	@GetMapping("/delate")
	public String delatePatient(Model model, @RequestParam("id") int id) {
		patientRepository.deleteById(id);
		return "redirect:/patient";
	}
	@GetMapping("/add-visit")
	public String addVisit(Model model, @RequestParam("id") int id) {		
		Role doctorRole = roleRepository.findByName("ROLE_DOCTOR");
		List<Users> users = usersRepository.findAll().stream().filter(u ->u.getRoles().contains(doctorRole)).collect(Collectors.toList());
		model.addAttribute("patients", patientRepository.findPatientById(id));
		model.addAttribute("doctor", users);
		model.addAttribute("visit", new Visit());
		return "add-visit";
	}
	@PostMapping("/add-visit")
	public String addVisit(@Valid @ModelAttribute Visit visit, BindingResult bindingResult, Model model) {	
		List<Visit> visitForDoctor = visitRepository.findAllVisitForDoctor(visit.getUsers().getId());
		Role doctorRole = roleRepository.findByName("ROLE_DOCTOR");
		List<Users> users = usersRepository.findAll().stream().filter(u ->u.getRoles().contains(doctorRole)).collect(Collectors.toList());
		if(visit.getVisit_date().equals("")) {
			model.addAttribute("data", "Data wizyty nie może być pusta");
			model.addAttribute("patients", patientRepository.findPatientById(visit.getPatient().getId()));
			model.addAttribute("doctor", users);
			return "add-visit";
		}else {
			for (Visit visit2 : visitForDoctor) {
				if(visit2.getPatient().getId() == visit.getPatient().getId()) {
					if(visit2.getVisit_date().equals(visit.getVisit_date())) {
						model.addAttribute("data", "Masz już wizytę w danym dniu");					
						model.addAttribute("patients", patientRepository.findPatientById(visit.getPatient().getId()));
						model.addAttribute("doctor", users);
						return "add-visit";
					}
				}
			}
		}
		if (!bindingResult.hasErrors()) {
			int tmp =1;
			for (Visit visit2 : visitForDoctor) {
				if(visit2.getVisit_date().equals(visit.getVisit_date()) ) {
					if(visit2.getDates() != null) {
						tmp++;					
					}
				}			
			}
			visit.setDates(datesRepository.findDateById(tmp++));
			visitService.edit(visit);
			return "redirect:/home";
		}	
		return "add-visit";									
	}
}
