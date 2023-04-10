package test.com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

class PatientServiceTest {

	private PatientService patientService; 
	@BeforeEach
	void setUp() throws Exception {
		patientService = new PatientService();
	}

	@Test
	void addPatientTest() {
		Patient patient = new Patient(2006,"John","Male",89575634L,"Typhoid",false);
		patientService.addPatient(patient);
		Patient savedPatient = patientService.getPatient(2006);
		System.out.println(savedPatient.toString());
		
		
		Assertions.assertEquals(patient, savedPatient);
		
	}
	
	@Test
	void updatePatientTest() {
		Patient beforeUpdatePatient = patientService.getPatient(2006);
		patientService.updatePatient(2006, true);
		Patient afterUpdatePatient = patientService.getPatient(2006);
		
		System.out.println("Before update "+beforeUpdatePatient);
		System.out.println("After update "+afterUpdatePatient);		
	}
	
	@Test
	void viewPatientTest() {
		List<Patient> patientList = new ArrayList<>();
		patientList = patientService.getAllPatient();
		
		for (Patient patient : patientList) {
			System.out.println(patient.toString());
		}
	}

}
