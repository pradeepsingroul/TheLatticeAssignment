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
import com.health.Servicea.DoctorServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/health")
public class DoctorController {
	
	@Autowired
	private DoctorServices dService;
	
	@PostMapping("/register")
	public ResponseEntity<Doctor> registerHandler(@Valid @RequestBody Doctor doctor){
		Doctor d1 = dService.register(doctor);
		return new ResponseEntity<>(d1,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Doctor> registerHandler(@Valid @RequestBody LoginDTO logindto){
		Doctor d1 = dService.login(logindto);
		return new ResponseEntity<>(d1,HttpStatus.CREATED);
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Doctor>> getAllHandler(){
		List<Doctor> list = dService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
		
	}
	@GetMapping("/{email}")
	public ResponseEntity<Doctor> getByEmailHandler(@Valid @RequestParam String email){
		Doctor d1 = dService.getDoctorEmail(email);
		return new ResponseEntity<Doctor>(d1,HttpStatus.OK);
		
	}
	@DeleteMapping("/{email}")
	public ResponseEntity<Doctor> deleteByEmailHandler(@Valid @RequestParam String email){
		Doctor d1 = dService.deleteByEmail(email);
		return new ResponseEntity<Doctor>(d1,HttpStatus.OK);
		
	}

}
