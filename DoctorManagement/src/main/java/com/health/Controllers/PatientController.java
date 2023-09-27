package com.health.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.health.DTO.LoginDTO;
import com.health.Entities.Doctor;
import com.health.Entities.Patient;
import com.health.Services.DoctorServices;
import com.health.Services.PatientServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/health/patients")
public class PatientController {


	@Autowired
	private PatientServices pService;
	
	@PostMapping("/register")
	public ResponseEntity<Patient> registerHandler(@Valid @RequestBody Patient patient){
		Patient pt = pService.register(patient);
		return new ResponseEntity<>(pt,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Patient> registerHandler(@Valid @RequestBody LoginDTO logindto){
		Patient pt = pService.login(logindto);
		return new ResponseEntity<>(pt,HttpStatus.CREATED);
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Patient>> getAllHandler(){
		List<Patient> list = pService.getAllPatient();
		return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
		
	}
	@GetMapping("/{email}")
	public ResponseEntity<Patient> getByEmailHandler(@Valid @RequestParam String email){
		Patient pt = pService.getPatientEmail(email);
		return new ResponseEntity<Patient>(pt,HttpStatus.OK);
		
	}
	@DeleteMapping("/{email}")
	public ResponseEntity<Patient> deleteByEmailHandler(@Valid @RequestParam String email){
		Patient pt = pService.deleteByEmail(email);
		return new ResponseEntity<Patient>(pt,HttpStatus.OK);
		
	}

}
