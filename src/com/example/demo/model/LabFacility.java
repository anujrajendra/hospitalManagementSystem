package com.example.demo.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class LabFacility {

	private String facilityTitle;
	private Float facilityCost;
	private Boolean facilityAvailability = true;
	
		
	@Override
	public int hashCode() {
		return Objects.hash(facilityTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabFacility other = (LabFacility) obj;
		return Objects.equals(facilityTitle, other.facilityTitle);
	}
	
	
	
	
	
}
