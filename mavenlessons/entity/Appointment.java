package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appoint")
public class Appointment {
	@Id
	@Column(name = "APPOINTMENT_ID")
	private int id;
	@Column(name = "APPOINTMENT_DATE")
	private Date appointDate;
//	@Column(name = "DOCTOR_ID ")
//	private int docId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DOCTOR_ID" ,nullable=false,insertable=false,updatable=false)
	@JsonIgnore
	private Doctor doctor;
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	public void setDoctor(Doctor doc)
	{
		this.doctor=doc;
	}
	@Column(name = "PATIENT_NAME")
	private String patName;
	@Column(name = "FEES_COLLECTED ")
	private float fees;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}

//	public int getDocId() {
//		return docId;
//	}
//
//	public void setDocId(int docId) {
//		this.docId = docId;
//	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	@Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%f",id, appointDate,doctor,patName, fees);
    }

}

