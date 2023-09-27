package com.health.Servicea;

import java.util.List;

import com.health.DTO.LoginDTO;
import com.health.Entities.Doctor;
import com.health.Exceptions.DoctorExceptions;

public interface DoctorServices {

	Doctor register(Doctor doctor) throws DoctorExceptions;
	
	Doctor login(LoginDTO Logindto) throws DoctorExceptions;

	Doctor getDoctorEmail(String email) throws DoctorExceptions;
	
	List<Doctor> getAllDoctors() throws DoctorExceptions;
	
	Doctor deleteByEmail(String email) throws DoctorExceptions;
	
}
