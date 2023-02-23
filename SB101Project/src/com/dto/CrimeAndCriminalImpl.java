package com.dto;

import java.util.Objects;

public class CrimeAndCriminalImpl implements CrimeAndCriminal{
	private int crimeAndCriminalID;
	private Crime crime;
	private Criminal criminal;
	
	public CrimeAndCriminalImpl() {
		
	}
	
	public CrimeAndCriminalImpl(int crimeAndCriminalID) {
		super();
		this.crimeAndCriminalID = crimeAndCriminalID;
	}

	public int getCrimeAndCriminalID() {
		return crimeAndCriminalID;
	}

	public void setCrimeAndCriminalID(int crimeAndCriminalID) {
		this.crimeAndCriminalID = crimeAndCriminalID;
	}

	public Crime getCrime() {
		return crime;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}

	public Criminal getCriminal() {
		return criminal;
	}

	public void setCriminal(Criminal criminal) {
		this.criminal = criminal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crime, crimeAndCriminalID, criminal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrimeAndCriminalImpl other = (CrimeAndCriminalImpl) obj;
		return Objects.equals(crime.getCrimeID(), other.crime.getCrimeID()) && crimeAndCriminalID == other.crimeAndCriminalID
				&& Objects.equals(criminal.getCriminalID(), other.criminal.getCriminalID());
	}
	
		
	
}
