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

public class Doctor {

	private Integer doctorId;
	private String doctorName;
	private String doctorQual;
	private Long doctorMobile;
	private Boolean doctorAvailability = true;
	
	@Override
	public int hashCode() {
		return Objects.hash(doctorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(doctorId, other.doctorId);
	}
}
