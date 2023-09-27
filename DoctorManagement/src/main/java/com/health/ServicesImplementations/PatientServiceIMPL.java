package com.health.ServicesImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.DTO.LoginDTO;
import com.health.Entities.Patient;
import com.health.Exceptions.PatientExceptions;
import com.health.Repository.PatientDAO;
import com.health.Services.PatientServices;



@Service
public class PatientServiceIMPL implements PatientServices{

	@Autowired
	private PatientDAO pDao;
	

	@Override
	public Patient register(Patient patient) throws PatientExceptions {
		Optional<Patient> opt = pDao.findByEmail(patient.getEmail());
		if(opt.isPresent()) {
			throw new PatientExceptions("patient already exist with the mail:"+patient.getEmail());
		}else {
			return pDao.save(patient);
//			return d1;/
		}
	}

	@Override
	public Patient login(LoginDTO Logindto) throws PatientExceptions {
		Optional<Patient> opt = pDao.findByEmailAndPassword(Logindto.getEmail(),Logindto.getPassword());
		if(opt.isEmpty()) {
			throw new PatientExceptions("patient does not exist with the email:"+Logindto.getEmail()+ " please registe first");
		}else {
			return opt.get();
		}
		
	}

	@Override
	public Patient getPatientEmail(String email) throws PatientExceptions {
		Optional<Patient> opt = pDao.findByEmail(email);
		if(opt.isEmpty()) {
			throw new PatientExceptions("patient does not exist with the email:"+email);
		}else {
			return opt.get();
		}
	}

	@Override
	public List<Patient> getAllPatient() throws PatientExceptions {
		List<Patient> list = pDao.findAll();
		if(list.isEmpty()) {
			throw new PatientExceptions("Patient does not exist ");
		}else {
			return list;
		}
	}

	@Override
	public Patient deleteByEmail(String email) throws PatientExceptions {
		Optional<Patient> opt = pDao.findByEmail(email);
		if(opt.isEmpty()) {
			throw new PatientExceptions("Doctor does not exist with the email: "+email);
		}else {
			Patient p = opt.get();
			pDao.delete(p);
			return p;
		}
	}

}
