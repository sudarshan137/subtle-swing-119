package com.dto;

import java.util.Objects;

public class CrimeAndVictimImpl {
	private int CrimeAndVictimID;
	private Crime crime;
	private Victim victim;
	
	public CrimeAndVictimImpl() {
		
	}
	
	public CrimeAndVictimImpl(int crimeAndVictimID, Crime crime, Victim victim) {
		super();
		CrimeAndVictimID = crimeAndVictimID;
		this.crime = crime;
		this.victim = victim;
	}

	public int getCrimeAndVictimID() {
		return CrimeAndVictimID;
	}

	public void setCrimeAndVictimID(int crimeAndVictimID) {
		CrimeAndVictimID = crimeAndVictimID;
	}

	public Crime getCrime() {
		return crime;
	}

	public void setCrime(Crime crime) {
		this.crime = crime;
	}

	public Victim getVictim() {
		return victim;
	}

	public void setVictim(Victim victim) {
		this.victim = victim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CrimeAndVictimID, crime, victim);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrimeAndVictimImpl other = (CrimeAndVictimImpl) obj;
		return CrimeAndVictimID == other.CrimeAndVictimID && Objects.equals(crime.getCrimeID(), other.crime.getCrimeID())
				&& Objects.equals(victim.getVictimID(), other.victim.getVictimID());
	}

	@Override
	public String toString() {
		return "CrimeAndVictimID: " + CrimeAndVictimID + ", crime: " + crime + ", victim: " + victim;
	}
	
	
	
	
	
}
