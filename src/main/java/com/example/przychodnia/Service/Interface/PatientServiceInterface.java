package com.example.przychodnia.Service.Interface;

import com.example.przychodnia.entity.Patient;

public interface PatientServiceInterface {
	Patient findPatientByName(String name);
	void edit(Patient patient);
	void savePatient(Patient patient);
	void delatePatientById(int id);
}
