package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AppointmentControl {
	@Autowired
	private AppointmentRepository arepo;

	@GetMapping(value = "/getdoctorbyappid")
	public String getDoctorByAppointmentId(int id) {
		Appointment app = arepo.findById(id);
		Doctor doc = app.getDoctor();
		return doc.toString();
	}

	@GetMapping("/getapp")
	public Appointment getAppointment(int id) {
		return arepo.findById(id);
	}

	@PostMapping(value = "/newapp", consumes = "application/json")
	// we need to give from where to read data from the http req and also the
	// content type
	public RedirectView addNewAppointment(@RequestBody Appointment apt) {
		arepo.save(apt);
		return new RedirectView("/getallappointments");
	}

	@PutMapping(value = "/modifyapp", consumes = "application/json")
	public RedirectView modifyAppointment(@RequestBody Appointment apt) {
		arepo.save(apt);
		return new RedirectView("/getallappointments");
	}

	@DeleteMapping("/deleteapp")
	public RedirectView deleteAppointment(int id) {
		arepo.deleteById(id);
		return new RedirectView("/getallappointments");
	}

	@GetMapping("/getallappointments")
	public List<Appointment> getAppointments() {
		return arepo.findAll();
	}

	@GetMapping("/getbydoctor")
	public List<Appointment> getAppointmentByDocId(int id) {
		return arepo.findByDoctorId(id);
	}

}
