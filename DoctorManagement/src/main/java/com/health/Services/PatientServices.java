package com.health.Services;

import java.util.List;

import com.health.DTO.LoginDTO;
import com.health.Entities.Doctor;
import com.health.Entities.Patient;
import com.health.Exceptions.DoctorExceptions;
import com.health.Exceptions.PatientExceptions;

public interface PatientServices {
	

	Patient register(Patient patient) throws PatientExceptions;
	
	Patient login(LoginDTO Logindto) throws PatientExceptions;

	Patient getPatientEmail(String email) throws PatientExceptions;
	
	List<Patient> getAllPatient() throws PatientExceptions;
	
	Patient deleteByEmail(String email) throws PatientExceptions;
	
	List<Doctor> getSuggessioins(String email) throws DoctorExceptions,PatientExceptions;
}
