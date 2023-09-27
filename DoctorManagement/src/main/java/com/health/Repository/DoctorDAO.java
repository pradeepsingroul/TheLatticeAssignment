package com.health.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.Entities.Doctor;

@Repository
public interface DoctorDAO extends JpaRepository<Doctor, Integer>{
	
	Optional<Doctor> findbyEmail(String email);

	Optional<Doctor> findbyEmailAndPassword(String email,String password);

}
