package com.health.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.Entities.Patient;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer>{

}
