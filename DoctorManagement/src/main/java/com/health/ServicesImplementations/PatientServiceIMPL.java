package com.health.ServicesImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.DTO.LoginDTO;
import com.health.Entities.Doctor;
import com.health.Entities.Patient;
import com.health.Enums.Symtoms;
import com.health.Exceptions.DoctorExceptions;
import com.health.Exceptions.PatientExceptions;
import com.health.Repository.DoctorDAO;
import com.health.Repository.PatientDAO;
import com.health.Services.PatientServices;

@Service
public class PatientServiceIMPL implements PatientServices {

	@Autowired
	private PatientDAO pDao;

	@Autowired
	private DoctorDAO dDao;

	@Override
	public Patient register(Patient patient) throws PatientExceptions {
		Optional<Patient> mailCheck = pDao.findByEmail(patient.getEmail());
		Optional<Patient> phoneCheck = pDao.findByPhoneNo(patient.getPhoneNo());
		if (mailCheck.isPresent()) {
			throw new PatientExceptions("patient already exist with the mail:" + patient.getEmail());
		}else if(phoneCheck.isPresent()) {
			throw new PatientExceptions("patient already exist with the phone number: " + patient.getPhoneNo());
		}
		else {
			return pDao.save(patient);
//			return d1;/
		}
	}

	@Override
	public Patient login(LoginDTO Logindto) throws PatientExceptions {
		Optional<Patient> opt = pDao.findByEmailAndPassword(Logindto.getEmail(), Logindto.getPassword());
		if (opt.isEmpty()) {
			throw new PatientExceptions(
					"patient does not exist with the email:" + Logindto.getEmail() + " please registe first");
		} else {
			return opt.get();
		}

	}

	@Override
	public Patient getPatientEmail(String email) throws PatientExceptions {
		Optional<Patient> opt = pDao.findByEmail(email);
		if (opt.isEmpty()) {
			throw new PatientExceptions("patient does not exist with the email:" + email);
		} else {
			return opt.get();
		}
	}

	@Override
	public List<Patient> getAllPatient() throws PatientExceptions {
		List<Patient> list = pDao.findAll();
		if (list.isEmpty()) {
			throw new PatientExceptions("Patient does not exist ");
		} else {
			return list;
		}
	}

	@Override
	public Patient deleteByEmail(String email) throws PatientExceptions {
		Optional<Patient> opt = pDao.findByEmail(email);
		if (opt.isEmpty()) {
			throw new PatientExceptions("Patient does not exist with the email: " + email);
		} else {
			Patient p = opt.get();
			pDao.delete(p);
			return p;
		}
	}

	@Override
	public List<Doctor> getSuggessioins(String email) throws DoctorExceptions, PatientExceptions {
		Optional<Patient> opt = pDao.findByEmail(email);

		if (opt.isEmpty()) {
			throw new PatientExceptions("Patient does not exist with the email: " + email);
		} else {
			Patient p = opt.get();
			Symtoms symtoms = p.getSymtomes();
			String city = p.getCity();
			System.out.println(symtoms.toString().equals("Arthritis"));

			List<Doctor> doctors = dDao.getDoctorBasedOnLocation(city);
			if (doctors.isEmpty()) {
				throw new DoctorExceptions("We are still waiting to expand to your location");
			} else {
				List<Doctor> output = new ArrayList<>();
				for (Doctor doctor : doctors) {

					if (symtoms.toString().equals("Arthritis") || symtoms.toString().equals("BackPain")
							|| symtoms.toString().equals("TissueInjuries")) {
						if (doctor.getSpeciality().toString().equals("ORHTOPEDIC")) {
							output.add(doctor);
						} else {
							throw new DoctorExceptions(
									"There isn’t any doctor present at your location for your symptom");
						}
					} else if (symtoms.toString().equals("Dysmenorrhea")) {
						if (doctor.getSpeciality().toString().equals("GYNECOLOGY")) {
							output.add(doctor);
						} else {
							throw new DoctorExceptions(
									"There isn’t any doctor present at your location for your symptom");
						}
					} else if (symtoms.toString().equals("SkinInfection") || symtoms.toString().equals("SkinBurn")) {
						if (doctor.getSpeciality().toString().equals("DERMATOLOGY")) {
							output.add(doctor);
						} else {
							throw new DoctorExceptions(
									"There isn’t any doctor present at your location for your symptom");
						}
					} else if (symtoms.toString().equals("EarPain")) {
						if (doctor.getSpeciality().toString().equals("ENT")) {
							output.add(doctor);
						} else {
							throw new DoctorExceptions(
									"There isn’t any doctor present at your location for your symptom");
						}
					} else {
						throw new DoctorExceptions("There isn’t any doctor present at your location for your symptom");
					}
				}
//			System.out.println("dgfdfgd");
//			System.out.println(doctors);
				System.out.println(output);
				return output;
			}
		}

	}

}
