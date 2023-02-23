package com.dto;

import java.time.LocalDate;
import java.util.Objects;

public class CrimeImpl implements Crime{
	private int crimeID;
	private LocalDate date;
	private String place;
	private String description;
	private String detailedDescription;
	private String status;
	
	public CrimeImpl() {
		
	}
	
	public CrimeImpl(int crimeID, LocalDate date, String place, String description, String detailedDescription,
			String status) {
		super();
		this.crimeID = crimeID;
		this.date = date;
		this.place = place;
		this.description = description;
		this.detailedDescription = detailedDescription;
		this.status = status;
	}

	public int getCrimeID() {
		return crimeID;
	}

	public void setCrimeID(int crimeID) {
		this.crimeID = crimeID;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crimeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrimeImpl other = (CrimeImpl) obj;
		return crimeID == other.crimeID;
	}

	@Override
	public String toString() {
		return "crimeID: " + crimeID + ", date: " + date + ", place: " + place + ", description: " + description
				+ ", detailedDescription: " + detailedDescription + ", status: " + status;
	}
	
	
	
	
}
