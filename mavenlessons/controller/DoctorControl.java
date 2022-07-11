package com.chainsys.mavenlessons.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.DoctorRepository;
import org.springframework.web.servlet.view.RedirectView;
@RestController
public class DoctorControl
{
	@Autowired
	private DoctorRepository repo;
//	@GetMapping("/getdoctor")
//	public Doctor getDoctor(int id)
//	{
//		return repo.findById(id);
//	}
	@GetMapping(value="/getdoctor")
	public String getDoctor(int id)
	{
		return repo.findById(id).toString();
	}
	@GetMapping(value="/getdoctorappointments")
	public String getApointments(int id)
	{
		Doctor doc=repo.findById(id);
		List<Appointment> appointments=doc.getAppointments();
		return appointments.toString();
	}
	@PostMapping(value="/newdoctor", consumes = "application/json")
	//we need to give from where to read data from the http req and also the content type
	public RedirectView addNewWDoctor(@RequestBody Doctor dr)
	{
		repo.save(dr);
		return new RedirectView("/getalldoctors");
	}
	@PostMapping(value="/modifydoctor", consumes = "application/json")
	public RedirectView modifyWDoctor(@RequestBody Doctor dr)
	{
		repo.save(dr);
		return new RedirectView("/getalldoctors");
	}
	
	@DeleteMapping("/deletedoctor")
	public RedirectView deleteDoctor(int id)
	{
		repo.deleteById(id);
		return new RedirectView("/getalldoctors");
	}
	
	@GetMapping("/getall")
	public List<Doctor> getDoctors()
	{
		return repo.findAll();
	}
	
}
