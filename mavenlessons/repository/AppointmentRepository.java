package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	 Appointment findById(int id);
	 Appointment save(Appointment apt);
	 void deleteById(int id);
	 List<Appointment> findAll();
	 List<Appointment> findByDoctorId(int dr_id);
	// @Query(value="select a from Appointment a where a.doc=?1 ")
	 //jpql java persistence query language a=instance of appointment entity
//	 List<Appointment> findAllByDoctorId(int id);	 
}
