package com.health.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.Entities.Doctor;

public interface DoctorDAO extends JpaRepository<Doctor, Integer>{

}
