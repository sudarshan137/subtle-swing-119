package com.dto;

import java.time.LocalDate;

public interface Crime {
	public int getCrimeID() ;

	public void setCrimeID(int crimeID) ;

	public LocalDate getDate() ;

	public void setDate(LocalDate date) ;

	public String getPlace() ;

	public void setPlace(String place) ;

	public String getDescription() ;

	public void setDescription(String description) ;

	public String getDetailedDescription() ;

	public void setDetailedDescription(String detailedDescription) ;

	public String getStatus() ;

	public void setStatus(String status) ;
}
