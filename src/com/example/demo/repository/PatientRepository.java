package com.example.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Patient;

public class PatientRepository {

	public void savePatient(Patient patient) {
		// new JdbcConnection();
		final String QUERY = "Insert into Patient values(?,?,?,?,?,?)";

		try {
			Connection conn = JdbcConnection.establishConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);

			pstmt.setInt(1, patient.getPatientId());
			pstmt.setString(2, patient.getPatientName());
			pstmt.setString(3, patient.getPatientSex());
			pstmt.setLong(4, patient.getPatientMobile());
			pstmt.setString(5, patient.getPatientDisease());
			pstmt.setBoolean(6, false);

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	public void updatePatientStatus(Integer patientId, Boolean admitStatus){

		final String QUERY = "Update Patient set patientAvailability=" + admitStatus+"where patientId = "+patientId;

		try {
			Connection conn = JdbcConnection.establishConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	public List<Patient> getAllPatient() {
		final String QUERY = "Select * from Patient";
		List<Patient> patients = new ArrayList<Patient>();
		try {
			Connection conn = JdbcConnection.establishConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) {
				Patient patient = new Patient();

				patient.setPatientId(rs.getInt(1));
				patient.setPatientName(rs.getString(2));
				patient.setPatientSex(rs.getString(3));
				patient.setPatientMobile(rs.getLong(4));
				patient.setPatientDisease(rs.getString(5));
				patient.setPatientAdmitStatus(rs.getBoolean(6));

				patients.add(patient);
			}

//			System.out.println("Patient id "+rs.getInt(1));
//			System.out.println("Patient name "+rs.getString(2));
//			System.out.println("Patient sex "+rs.getString(3));
//			System.out.println("Patient mobile "+rs.getLong(4));
//			System.out.println("Patient disease "+rs.getString(5));
//			System.out.println("Patient admit status "+rs.getBoolean(6));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return patients;
	}

	public Patient getPatient(Integer patientId) {
		final String QUERY = "Select * from Patient where patientId = " + patientId;
		Patient patient = new Patient();
		try {

			Connection conn = JdbcConnection.establishConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) {

				patient.setPatientId(rs.getInt(1));
				patient.setPatientName(rs.getString(2));
				patient.setPatientSex(rs.getString(3));
				patient.setPatientMobile(rs.getLong(4));
				patient.setPatientDisease(rs.getString(5));
				patient.setPatientAdmitStatus(rs.getBoolean(6));

//			System.out.println("Patient id "+rs.getInt(1));
//			System.out.println("Patient name "+rs.getString(2));
//			System.out.println("Patient sex "+rs.getString(3));
//			System.out.println("Patient mobile "+rs.getLong(4));
//			System.out.println("Patient disease "+rs.getString(5));
//			System.out.println("Patient admit status "+rs.getBoolean(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return patient;
	}

}
