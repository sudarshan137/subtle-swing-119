package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.Crime;
import com.dto.CrimeImpl;
import com.dto.Criminal;
import com.dto.CriminalImpl;
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
	
	private List<Criminal> getCriminalsByList(ResultSet rs) throws SQLException{
		List<Criminal> list = new ArrayList<>();
		
		while(rs.next()) {
			Criminal c = new CriminalImpl();
			c.setCriminalID(rs.getInt("criminalID"));
			c.setCriminalName(rs.getString("name"));
			c.setCriminalAge(rs.getInt("age"));
			c.setCriminalGender(rs.getString("gender"));
			c.setCriminalAddress(rs.getString("address"));
			c.setIndentifyingMarks(rs.getString("idmark"));
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
			String QUERY = "SELECT Crime.* FROM Crime_Criminal JOIN Crime ON Crime_Criminal.crimeid = Crime.crimeid "
					+"WHERE Crime_Criminal.criminalid = ?";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setInt(1, criminalID);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs)) throw new NoRecordFoundException("");
			
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
	public List<Criminal> getCriminalAssociatedByCrimes(int crimeID)throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		List<Criminal> list = null;
		
		try {
			conn = DBUtils.connectToDatabase();
//			SELECT Criminal.* FROM Crime_Criminal JOIN Criminal ON Crime_Criminal.criminalid = Crime.criminalid WHERE Crime_Criminal.crimeid = <crime_id>;
			String QUERY = "SELECT Criminal.* FROM Crime_Criminal JOIN Criminal ON Crime_Criminal.criminalid = Criminal.criminalid WHERE Crime_Criminal.crimeid = ?";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setInt(1, crimeID);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs))throw new NoRecordFoundException(" ");
			
			list = getCriminalsByList(rs);			
			
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
	public void updateCrimeStatus(String status, int crimeId) throws SomeThingWrongException {
		Connection conn = null;
		
		try {
			conn = DBUtils.connectToDatabase();
			
			String QUERY = "UPDATE Crime SET status = ? WHERE crimeid = ?";
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setString(1, status);
			ps.setInt(2, crimeId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
	}

	@Override
	public List<Crime> getCrimesByQuery(String que, String str) throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		List<Crime> list = null;
		
		try {
			conn = DBUtils.connectToDatabase();
//			SELECT Crime.* FROM Crime_Criminal JOIN Crime ON Crime_Criminal.crime_id = Crime.crime_id WHERE Crime_Criminal.criminal_id = <criminal_id>;
			String QUERY = "SELECT * FROM Crime WHERE "+que+" LIKE ?";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setString(1, "%"+str+"%");
			
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
	public List<Criminal> getCriminalsByQuery(String que,String str) throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		List<Criminal> list = null;
		
		try {
			String QUERY = null;
			conn = DBUtils.connectToDatabase();
			if(que.equals("gender") || que.equals("criminalID") || que.equals("age") ) {
				QUERY = "SELECT * FROM Criminal WHERE "+que+" = ?";
			}else {
			 QUERY = "SELECT * FROM Criminal WHERE "+que+" LIKE ?";
			}
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			if(que.equals("gender")  || que.equals("criminalID") || que.equals("age")) {
				ps.setString(1, str);
			}else {
				ps.setString(1, "%"+str+"%");
			}
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs))throw new NoRecordFoundException(" ");
			
			list = getCriminalsByList(rs);			
			
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
	public List getNumOfSolvedUnsolvedCrimes() throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		List list = new ArrayList<>();
		
		try {
			conn = DBUtils.connectToDatabase();			
			String QUERY = "SELECT place,CASE WHEN status = 'open' THEN 'OPEN' WHEN status = 'closed' THEN 'CLOSED' ELSE 'PENDING' END AS some, count(status) cunt FROM Crime group by some, place";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs))throw new NoRecordFoundException(" ");
			
			while(rs.next()) {
				list.add(rs.getString("place")+": "+rs.getString("some")+": "+rs.getInt("cunt"));
			}
		
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
	public int CrimesRecordedInCurrentMonth() throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		int ans = 0;
		
		try {
			conn = DBUtils.connectToDatabase();			
			String QUERY = "SELECT COUNT(*) as NumberOfcrimes FROM Crime WHERE MONTH(date) = MONTH(NOW())";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs))throw new NoRecordFoundException(" ");
			
			while(rs.next()) {
				ans = rs.getInt("NumberOfcrimes");
			}
		
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		return ans;
		
	}

	@Override
	public void addCrime(Crime crime) throws SomeThingWrongException {
		Connection conn = null;
		
		try {
			conn = DBUtils.connectToDatabase();
			
			String QUERY = "INSERT INTO Crime values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setInt(1, crime.getCrimeID());
			ps.setDate(2, Date.valueOf(crime.getDate()));
			ps.setString(3, crime.getPlace());
			ps.setString(4, crime.getDescription());
			ps.setString(5, crime.getDetailedDescription());
			ps.setString(6, crime.getStatus());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
	}

	@Override
	public void addCriminal(Criminal crime) throws SomeThingWrongException {
Connection conn = null;
		
		try {
			conn = DBUtils.connectToDatabase();
			
			String QUERY = "INSERT INTO Criminal values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setInt(1, crime.getCriminalID());
			ps.setString(2, crime.getCriminalName());
			ps.setInt(3, crime.getCriminalAge());
			ps.setString(4, crime.getCriminalGender());
			ps.setString(5, crime.getCriminalAddress());
			ps.setString(6, crime.getIndentifyingMarks());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
	}

	@Override
	public List<Crime> getCrimesList() throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		List<Crime> list = null;
		
		try {
			conn = DBUtils.connectToDatabase();
			String QUERY = "SELECT * FROM Crime";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs)) throw new NoRecordFoundException("");
			
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
	public int getLatestCrimeID() throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		int ans = -1;
		
		try {
			conn = DBUtils.connectToDatabase();
			String QUERY = "SELECT * FROM Crime order by crimeid desc limit 1";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs)) throw new NoRecordFoundException("");
			while(rs.next()) {
			ans = rs.getInt("crimeID");
			break;
			}
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		return ans;
	}
	
	@Override
	public int getLatestCriminalID() throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		int ans=0;
		
		try {
			conn = DBUtils.connectToDatabase();
			String QUERY = "SELECT * FROM Criminal order by CriminalID desc limit 1";
			
			PreparedStatement ps = conn.prepareStatement(QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultSetEmpty(rs)) throw new NoRecordFoundException("");
			while(rs.next()) {
			ans = rs.getInt("criminalID");
			break;
			}
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		return ans;
	}

}
