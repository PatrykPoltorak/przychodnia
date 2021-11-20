package com.example.przychodnia.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.przychodnia.entity.Visit;
@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
	@Query("select v from Visit v where v.status = 1 order by v.id ")
	List<Visit> findClosedVisit(); 
	
	@Query("select v from Visit v where v.status = 0 order by v.id ")
	List<Visit> findOpenVisit(); 
	
	@Query("select v from Visit v order by v.visit_date")
	List<Visit> findAll(); 
	
	@Query("select v from Visit v where v.id = ?1 order by v.visit_date")
    Visit findVisitById(int id);	
	
	@Query("select v from Visit v where users_id = ?1 order by v.visit_date")
	List<Visit> findAllVisitForDoctor(int id);	
	
	@Query("select v from Visit v where users_id = ?1 and v.visit_date = ?2 order by v.visit_date")
	List<Visit> findAllVisitForDoctor(int id, String date);	
	
	@Query("select v from Visit v where patient_id = ?1 ")
	List<Visit> findAllVisitForPatient(int id);	
	
	@Query("select v from Visit v where v.patient.id = ?1 and v.status = 0")
	Visit findVisitForPatient(int id);
	
}
