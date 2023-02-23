package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.Crime;
import com.dto.CrimeImpl;
import com.dto.Criminal;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public class ProjectRequirementImpl implements ProjectRequirements {
	
	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow()==0) ? true: false;
	}
	
	private List<Crime> getCrimesByList(ResultSet rs) throws SQLException{
		List<Crime> list = new ArrayList<>();
		
		while(rs.next()) {
			Crime c = new CrimeImpl();
			c.setCrimeID(rs.getInt("crimeID"));
			c.setDate((rs.getDate("date").toLocalDate()));
			c.setPlace(rs.getString("place"));
			c.setDescription(rs.getString("description"));
			c.setDetailedDescription(rs.getString("Detailed_description"));
			c.setStatus(rs.getString("status"));
			list.add(c);
		}
		
		return list;
	}

	@Override
	public List<Crime> getCrimesComittedByCriminal(int criminalID)throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		List<Crime> list = null;
		
		try {
			conn = DBUtils.connectToDatabase();
//			SELECT Crime.* FROM Crime_Criminal JOIN Crime ON Crime_Criminal.crime_id = Crime.crime_id WHERE Crime_Criminal.criminal_id = <criminal_id>;
			String QUERY = "SELECT Crime.* FROM Crime_Criminal JOIN Crime ON Crime_Criminal.crimeid = Crime.crimeid "
					+"WHERE Crime_Criminal.criminalid = ?";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setInt(1, criminalID);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs))throw new NoRecordFoundException(" ");
			
			list = getCrimesByList(rs);			
			
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		return list;
	}

	@Override
	public List<Criminal> getCriminalAssociatedByCrimes(int crimeID)
			throws NoRecordFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crime> getSolvedCrimes(String status) throws NoRecordFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crime> getUnsolvedCrimes(String status) throws NoRecordFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCrimeStatus(String status, int crimeId) throws SomeThingWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Crime> getCrimesByArea(String area) throws NoRecordFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Criminal> getCriminalsByArea(String area) throws NoRecordFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crime> getNumOfSolvedUnsolvedCrimes() throws NoRecordFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crime> CrimesRecordedInThatMonth() throws NoRecordFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
