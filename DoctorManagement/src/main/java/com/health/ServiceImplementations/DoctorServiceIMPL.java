package com.health.ServiceImplementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.DTO.LoginDTO;
import com.health.Entities.Doctor;
import com.health.Exceptions.DoctorExceptions;
import com.health.Repository.DoctorDAO;
import com.health.Servicea.DoctorServices;

@Service
public class DoctorServiceIMPL implements DoctorServices{

	@Autowired
	private DoctorDAO dDao;
	
	@Override
	public Doctor register(Doctor doctor) throws DoctorExceptions {
		Optional<Doctor> opt = dDao.findbyEmail(doctor.getEmail());
		if(opt.isPresent()) {
			throw new DoctorExceptions("doctor already exist with the mail:"+doctor.getEmail());
		}else {
			Doctor d1 = opt.get();
			dDao.save(doctor);
			return d1;
		}
	}

	@Override
	public Doctor login(LoginDTO Logindto) throws DoctorExceptions {
		
		Optional<Doctor> opt = dDao.findbyEmailAndPassword(Logindto.getEmail(),Logindto.getPassword());
		if(opt.isEmpty()) {
			throw new DoctorExceptions("Doctor does not exist with the email:"+Logindto.getEmail()+ " please registe first");
		}else {
			return opt.get();
		}
		
		
		
	}

}
