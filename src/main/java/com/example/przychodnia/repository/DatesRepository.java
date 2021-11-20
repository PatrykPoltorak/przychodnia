package com.example.przychodnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.przychodnia.entity.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Integer> {
	@Query("select d from Dates d where d.id=?1")
	Dates findDateById(int id);
}
