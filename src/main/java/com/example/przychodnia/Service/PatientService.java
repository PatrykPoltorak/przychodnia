package com.example.przychodnia.Service;



import org.springframework.stereotype.Service;
import com.example.przychodnia.Service.Interface.PatientServiceInterface;
import com.example.przychodnia.entity.Patient;
import com.example.przychodnia.repository.PatientRepository;

@Service
public class PatientService implements PatientServiceInterface {
	private final PatientRepository patientRepository;

	public PatientService(PatientRepository patientRepository) {
		
		this.patientRepository = patientRepository;
	}
	public void savePatient(Patient patient) {
		patientRepository.save(patient);
	}
	@Override
	public Patient findPatientByName(String name) {	
		return patientRepository.findPatientByName(name);
	}
	@Override
	public void edit(Patient patient) {
		patientRepository.save(patient);		
	}
	@Override
	public void delatePatientById(int id) {
		patientRepository.delete(patientRepository.findPatientById(id));;		
	}	
}
