package com.health.Entities;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.health.Enums.Symtoms;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer PatientId;
	
	@Length(min = 3,message = "should be at least 3 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$",message = "Name must not contain any numbers and special char")
	private String name;
	
	@Length(max = 20,message = "should be at max 20 characters")
	private String city;
	
	@Email(message = "Invalid email id")
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Pattern(regexp = "\\d{10}",message = "Phone number must contains 10 digit")
	private String phoneNo;
	
	@Enumerated(EnumType.STRING)
	private Symtoms symtomes;

}
