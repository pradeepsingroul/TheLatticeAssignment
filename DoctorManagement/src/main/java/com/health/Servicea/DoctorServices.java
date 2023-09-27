package com.health.Servicea;

import com.health.DTO.LoginDTO;
import com.health.Entities.Doctor;
import com.health.Exceptions.DoctorExceptions;

public interface DoctorServices {

	Doctor register(Doctor doctor) throws DoctorExceptions;
	
	Doctor login(LoginDTO Logindto) throws DoctorExceptions;
//
//	Doctor getDoctorById(Integer doctorId) throws DoctorExceptions;
//	
//	Doctor getAklDoctors() throws DoctorExceptions;
	
}
