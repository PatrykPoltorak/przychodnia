package com.example.przychodnia.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import com.example.przychodnia.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Patient findPatientByName(String name);
	@Query("select p from Patient p order by p.id")
	List<Patient> findAll();
	@Query("select p from Patient p where p.id=?1")
    Patient findPatientById(int id);

	

}
