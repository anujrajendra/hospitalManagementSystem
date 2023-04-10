package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

public class DoctorService {

	private DoctorRepository doctorRepository;

	public DoctorService(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}
	
	public Doctor addDoctor(Doctor doctor) {
		doctorRepository.saveDoctor(doctor);
		return doctor;
	}
	
	public void updateDoctor(Integer doctorId,Boolean availabilityStatus) {
		doctorRepository.updateDoctorStatus(doctorId,availabilityStatus);
		}
	
	public List<Doctor> getAllDoctor() {
		return doctorRepository.getAllDoctor();
	}
	
	public Doctor getDoctor(Integer doctorId)  {
		return doctorRepository.getDoctor(doctorId);
	
	}
	
	
}
