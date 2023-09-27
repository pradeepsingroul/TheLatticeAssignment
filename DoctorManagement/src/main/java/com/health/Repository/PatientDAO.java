package com.health.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.Entities.Doctor;
import com.health.Entities.Patient;
import java.util.List;


@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer>{
	
	Optional<Patient> findByEmail(String email);
	
	 Optional<Patient> findByPhoneNo(String phoneNo);

	Optional<Patient> findByEmailAndPassword(String email,String password);
}
