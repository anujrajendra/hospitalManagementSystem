package test.com.example.demo.service;

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

}
