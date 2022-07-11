package com.chainsys.mavenlessons.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
@Entity
public class Doctor {
@Id
    @Column(name="DOCTOR_ID")
	private int id;  
	private String doctor_name;         
	private Date dob;       
	private String speciality;
	private String city;          
	private long phone_no;
	private float standard_fees;
	//Bidirectional association
	@OneToMany(mappedBy="doctor" ,fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Appointment> appoint;
	public List<Appointment> getAppointments()
	{
		return this.appoint;
	}
	public int getDoctor_id() {
		return id;
	}
	public void setDoctor_id(int doctor_id) {
		this.id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public float getStandard_fees() {
		return standard_fees;
	}
	public void setStandard_fees(float standard_fees) {
		this.standard_fees = standard_fees;
	}
	@Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s",id,doctor_name,dob,city,phone_no);

}
}
