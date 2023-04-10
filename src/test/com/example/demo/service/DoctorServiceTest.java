package test.com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

class DoctorServiceTest {

	private DoctorService doctorService;
	
	@BeforeEach
	void setUp() throws Exception {
		doctorService = new DoctorService(null);
	}

	@Test
	void addDoctorTest() {
		Doctor doctor = new Doctor(2012, "Anjaney", "MS MD", 857469325L, true);
		doctorService.addDoctor(doctor);
		Doctor savedDoctor = doctorService.getDoctor(2012);
		
		System.out.println(savedDoctor.toString());
		Assertions.assertEquals(doctor, savedDoctor);
		

	}

}
