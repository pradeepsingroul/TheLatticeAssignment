package com.health.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.health.Enums.Symtoms;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Patient {
	
	@Id
	private Integer PatientId;
	
	@Min(value = 3,message = "should be at least 3 characters")
	@Pattern(regexp="^[A-Za-z-' ]+$",message = "Name must contains only alphabates")
	private String name;
	
	@Max(value = 20,message = "should be at max 20 characters")
	private String city;
	
	@Email(message = "Invalid email id")
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Max(value = 10,message = "should be at least 10 number")
	@Min(value = 10,message = "should be at least 10 number")
	@Pattern(regexp = "^\\d{10}$",message = "should be at least 10 number")
	private Integer phoneNo;
	
	private Symtoms symtomes;

}
