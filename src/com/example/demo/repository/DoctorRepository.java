package com.example.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Doctor;

public class DoctorRepository {

	public void saveDoctor(Doctor doctor) {
		
		final String QUERY = "Insert into Doctor values(?,?,?,?,?)";
		try {
		Connection conn = JdbcConnection.establishConnection();
		PreparedStatement pstmt = conn.prepareStatement(QUERY);
		
		pstmt.setInt(1, doctor.getDoctorId());
		pstmt.setString(2, doctor.getDoctorName());
		pstmt.setString(3, doctor.getDoctorQual());
		pstmt.setLong(4, doctor.getDoctorMobile());
		pstmt.setBoolean(5, true);

		pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void updateDoctorStatus(Integer doctorId, Boolean availabilityStatus) {
		
		final String QUERY = "Update Doctor set doctorAvailability="+availabilityStatus+"where doctorId = "+doctorId;
		try {
		Connection conn = JdbcConnection.establishConnection();
		PreparedStatement pstmt = conn.prepareStatement(QUERY);
		pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}		
	}
	
	public List<Doctor> getAllDoctor() {
		final String QUERY = "Select * from Doctor";
		List<Doctor> doctors = new ArrayList<Doctor>();
		try {
		Connection conn = JdbcConnection.establishConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY);
		
		while(rs.next()) {
			Doctor doctor = new Doctor();
			doctor.setDoctorId(rs.getInt(1));
			doctor.setDoctorName(rs.getString(2));
			doctor.setDoctorQual(rs.getString(3));
			doctor.setDoctorMobile(rs.getLong(4));
			doctor.setDoctorAvailability(rs.getBoolean(5));
			
			doctors.add(doctor);
		}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}		
		return doctors;
	}
	
	public Doctor getDoctor(Integer doctorId) {
		final String QUERY = "Select * from Doctor where doctorId = "+doctorId;
		Doctor doctor = new Doctor();
		try {
		Connection conn = JdbcConnection.establishConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY);
		
		while(rs.next()) {
			doctor.setDoctorId(rs.getInt(1));
			doctor.setDoctorName(rs.getString(2));
			doctor.setDoctorQual(rs.getString(3));
			doctor.setDoctorMobile(rs.getLong(4));
			doctor.setDoctorAvailability(rs.getBoolean(5));
			
		}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
		return doctor;
	}
}
