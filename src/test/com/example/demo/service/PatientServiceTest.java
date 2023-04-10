package test.com.example.demo.service;


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
		Patient patient = new Patient(2006,"John","Male",89575634L,"Typhoid");
		patientService.addPatient(patient);
		Patient savedPatient = patientService.getPatient(2006);
		System.out.println(savedPatient.toString());
		
		
		Assertions.assertEquals(patient, savedPatient);
		
	}
	

}
