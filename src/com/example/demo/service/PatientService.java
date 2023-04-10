package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

public class PatientService {

	private PatientRepository patientRepository;
	
	public PatientService() {
		super();
		this.patientRepository = new PatientRepository();
	}

	public Patient addPatient(Patient patient) {
		patientRepository.savePatient(patient);
		return patient;
	}
	
	public void updatePatient(Boolean admitStatus) {
		patientRepository.updatePatientStatus(admitStatus);
		//return patient;
	}
	
	public List<Patient> getAllPatient() {
		return patientRepository.getAllPatient();
	}
	
	public Patient getPatient(Integer patientId)  {
		return patientRepository.getPatient(patientId);
	
	}
	
}
