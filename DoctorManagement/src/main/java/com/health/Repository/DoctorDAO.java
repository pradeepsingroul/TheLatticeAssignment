package com.health.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.health.Entities.Doctor;
import com.health.Entities.Patient;

@Repository
public interface DoctorDAO extends JpaRepository<Doctor, Integer>{
	
	Optional<Doctor> findByPhoneNo(String phoneNo);
	
	Optional<Doctor> findByEmail(String email);
	
	Optional<Doctor> findByEmailAndPassword(String email,String password);
	
	@Query(value = "SELECT * FROM doctor d WHERE d.city =:city",nativeQuery=true)
	List<Doctor> getDoctorBasedOnLocation(@Param("city") String city);

}
