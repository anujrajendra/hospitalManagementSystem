package test.com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.LabFacility;
import com.example.demo.service.LabFacilityService;

class LabFacilityServiceTest {

	LabFacilityService labFacilityService;
	@BeforeEach
	void setUp() throws Exception {
		labFacilityService = new LabFacilityService(null);
	}

	@Test
	void addLabFacilityTest() {
		LabFacility labFacility = new LabFacility("Gynac", 20550F, true);
		labFacilityService.addLabFacility(labFacility);
		
		LabFacility savedLabFacility = labFacilityService.getLabFacility("Gynac");
		
		System.out.println(savedLabFacility.toString());
		Assertions.assertEquals(labFacility, savedLabFacility);
		
	}
	
	
	@Test
	void updateLabFacilityTest() {
		LabFacility beforeUpdateLabFacility = labFacilityService.getLabFacility("Gynac");
		labFacilityService.updateLabFacility("Gyanc", false);
		LabFacility afterUpdateLabFacility = labFacilityService.getLabFacility("Gynac");

		System.out.println("Before update "+beforeUpdateLabFacility);
		System.out.println("After update "+afterUpdateLabFacility);
	}
	
	@Test
	void viewDoctorTest() {
		List<LabFacility> labFacilities = new ArrayList<>();
		labFacilities = labFacilityService.getAllLabFacility();
		
		for (LabFacility labFacility : labFacilities) {
			System.out.println(labFacility.toString());
		}
		
	}

}
