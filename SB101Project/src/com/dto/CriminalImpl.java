package com.dto;

import java.util.Objects;

public class CriminalImpl implements Criminal{
	private int criminalID;
	private String criminalName;
	private int CriminalAge;
	private String criminalGender;
	private String criminalAddress;
	private String indentifyingMarks;
	
	public CriminalImpl() {
		
	}
	
	public CriminalImpl(int criminalID, String criminalName, int criminalAge, String criminalGender,
			String criminalAddress, String indentifyingMarks) {
		super();
		this.criminalID = criminalID;
		this.criminalName = criminalName;
		this.CriminalAge = criminalAge;
		this.criminalGender = criminalGender;
		this.criminalAddress = criminalAddress;
		this.indentifyingMarks = indentifyingMarks;
	}

	public int getCriminalID() {
		return criminalID;
	}

	public void setCriminalID(int criminalID) {
		this.criminalID = criminalID;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public int getCriminalAge() {
		return CriminalAge;
	}

	public void setCriminalAge(int criminalAge) {
		CriminalAge = criminalAge;
	}

	public String getCriminalGender() {
		return criminalGender;
	}

	public void setCriminalGender(String criminalGender) {
		this.criminalGender = criminalGender;
	}

	public String getCriminalAddress() {
		return criminalAddress;
	}

	public void setCriminalAddress(String criminalAddress) {
		this.criminalAddress = criminalAddress;
	}

	public String getIndentifyingMarks() {
		return indentifyingMarks;
	}

	public void setIndentifyingMarks(String indentifyingMarks) {
		this.indentifyingMarks = indentifyingMarks;
	}



	@Override
	public int hashCode() {
		return Objects.hash(criminalID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriminalImpl other = (CriminalImpl) obj;
		return criminalID == other.criminalID;
	}

	@Override
	public String toString() {
		return "CriminalImpl [criminalID=" + criminalID + ", criminalName=" + criminalName + ", CriminalAge="
				+ CriminalAge + ", criminalGender=" + criminalGender + ", criminalAddress=" + criminalAddress
				+ ", indentifyingMarks=" + indentifyingMarks  + "]";
	}
	
		
}
