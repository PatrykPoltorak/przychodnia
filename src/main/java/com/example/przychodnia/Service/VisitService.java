package com.example.przychodnia.Service;

import org.springframework.stereotype.Service;

import com.example.przychodnia.Service.Interface.VisitServiceInterface;
import com.example.przychodnia.entity.Visit;
import com.example.przychodnia.repository.VisitRepository;

@Service
public class VisitService implements VisitServiceInterface {
	private final VisitRepository visitRepository;

	public VisitService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}
	@Override
	public void save(Visit visit) {
		visit.setStatus(true);
		visitRepository.save(visit);
		
	}
	@Override
	public void edit(Visit visit) {
		visitRepository.save(visit);		
	}
	@Override
	public void delate(Visit visit) {
		visitRepository.delete(visit);		
	}
}