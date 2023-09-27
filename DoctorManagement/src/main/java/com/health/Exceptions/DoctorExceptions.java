package com.health.Exceptions;

public class DoctorExceptions extends RuntimeException{
	
	public DoctorExceptions(){
		
	}
	public DoctorExceptions(String mess){
		super(mess);
	}
}
