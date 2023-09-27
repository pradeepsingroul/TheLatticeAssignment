package com.health.ServicesImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.DTO.LoginDTO;
import com.health.Entities.Doctor;
import com.health.Entities.Patient;
import com.health.Exceptions.DoctorExceptions;
import com.health.Exceptions.PatientExceptions;
import com.health.Repository.DoctorDAO;
import com.health.Services.DoctorServices;

@Service
public class DoctorServiceIMPL implements DoctorServices{

	@Autowired
	private DoctorDAO dDao;
	
	@Override
	public Doctor register(Doctor doctor) throws DoctorExceptions {
		Optional<Doctor> mailCheck = dDao.findByEmail(doctor.getEmail());
		Optional<Doctor> phoneCheck = dDao.findByPhoneNo(doctor.getPhoneNo());
		if(phoneCheck.isPresent()) {
			throw new PatientExceptions("patient already exist with the phone number: " + doctor.getPhoneNo());
		}
		else if(mailCheck.isPresent()) {
			throw new DoctorExceptions("doctor already exist with the mail:"+doctor.getEmail());
		}else {
			return dDao.save(doctor);
//			return d1;/
		}
	}

	@Override
	public Doctor login(LoginDTO Logindto) throws DoctorExceptions {
		
		Optional<Doctor> opt = dDao.findByEmailAndPassword(Logindto.getEmail(),Logindto.getPassword());
		if(opt.isEmpty()) {
			throw new DoctorExceptions("Doctor does not exist with the email:"+Logindto.getEmail()+ " please registe first");
		}else {
			return opt.get();
		}
		
		
		
	}

	@Override
	public Doctor getDoctorEmail(String email) throws DoctorExceptions {
		Optional<Doctor> opt = dDao.findByEmail(email);
		if(opt.isEmpty()) {
			throw new DoctorExceptions("Doctor does not exist with the email:"+email);
		}else {
			return opt.get();
		}
	}

	@Override
	public List<Doctor> getAllDoctors() throws DoctorExceptions {
		List<Doctor> doctors = dDao.findAll();
		if(doctors.isEmpty()) {
			throw new DoctorExceptions("Doctor does not exsit...");
		}
		return doctors;
	}

	@Override
	public Doctor deleteByEmail(String email) throws DoctorExceptions {
		Optional<Doctor> opt = dDao.findByEmail(email);
		if(opt.isEmpty()) {
			throw new DoctorExceptions("Doctor does not exist with the email: "+email);
		}else {
			Doctor d1 = opt.get();
			dDao.delete(d1);
			return d1;
		}
	}

}
