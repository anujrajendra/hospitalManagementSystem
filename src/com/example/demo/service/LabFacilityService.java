package com.example.demo.service;

import java.util.List;

import com.example.demo.model.LabFacility;
import com.example.demo.repository.LabFacilityRepository;

public class LabFacilityService {
	
	private LabFacilityRepository facilityRepository;

	public LabFacilityService(LabFacilityRepository facilityRepository) {
		super();
		this.facilityRepository = facilityRepository;
	}
	
	public LabFacility addLabFacility(LabFacility labFacility) {
		facilityRepository.saveLabFacility(labFacility);
		return labFacility;
	}
	
	public void updateLabFacility(String facilityTitle, Boolean availabilityStatus) {
		facilityRepository.updateLabFacilityStatus(facilityTitle, availabilityStatus);
	}
	
	public List<LabFacility> getAllLabFacility() {
		return facilityRepository.getAllLabFacility();
	}
	
	public LabFacility getLabFacility(String facilityTitle) {
		return facilityRepository.getLabFacility(facilityTitle);
	}
}
