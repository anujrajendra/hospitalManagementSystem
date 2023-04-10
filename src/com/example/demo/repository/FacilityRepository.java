package com.example.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.LabFacility;

public class FacilityRepository {
	
	public void saveLabFacility(LabFacility labFacility) {
		//new JdbcConnection();
		final String QUERY = "Insert into LabFaility values(?,?,?)";
		
		try {
		Connection conn = JdbcConnection.establishConnection();
		PreparedStatement pstmt = conn.prepareStatement(QUERY);
		
		pstmt.setString(1, labFacility.getFacilityTitle());
		pstmt.setFloat(2, labFacility.getFacilityCost());
		pstmt.setBoolean(3, true);

		pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void updateLabFacilityStatus(String facilityTitle, Boolean availabilityStatus) {
		
		final String QUERY = "Update LabFacility set facilityAvailability="+availabilityStatus+ "where facilityTitle = " +facilityTitle;
		
		try {
			Connection conn = JdbcConnection.establishConnection();
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public List<LabFacility> getAllLabFacility() {
		
		final String QUERY = "Select * from LabFacility";
		List<LabFacility> labFacilities = new ArrayList<LabFacility>();
		try {
		Connection conn = JdbcConnection.establishConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY);
		
		while(rs.next()) {
			
			LabFacility labFacility = new LabFacility();
			labFacility.setFacilityTitle(rs.getString(1));
			labFacility.setFacilityCost(rs.getFloat(2));
			labFacility.setFacilityAvailability(rs.getBoolean(3));
			
			labFacilities.add(labFacility);
		}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return labFacilities;
	}
	
	public LabFacility getLabFacility(String facilityTitle) {
		final String QUERY = "Select * from LabFacility";
		LabFacility labFacility = new LabFacility();
		try {
		Connection conn = JdbcConnection.establishConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY);
		
		while(rs.next()) {
			
			
			labFacility.setFacilityTitle(rs.getString(1));
			labFacility.setFacilityCost(rs.getFloat(2));
			labFacility.setFacilityAvailability(rs.getBoolean(3));
			
		}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return labFacility;
	}
}


