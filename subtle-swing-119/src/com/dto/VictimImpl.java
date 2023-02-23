package com.dto;

import java.util.Objects;

public class VictimImpl implements Victim{
	private int victimID;
	private String victimName;
	private String vicitimAddress;
	private String victimPhone;
	
	public VictimImpl(int victimID, String victimName, String vicitimAddress, String victimPhone) {
		super();
		this.victimID = victimID;
		this.victimName = victimName;
		this.vicitimAddress = vicitimAddress;
		this.victimPhone = victimPhone;
	}
	
	public VictimImpl() {
		
	}

	public int getVictimID() {
		return victimID;
	}

	public void setVictimID(int victimID) {
		this.victimID = victimID;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public String getVicitimAddress() {
		return vicitimAddress;
	}

	public void setVicitimAddress(String vicitimAddress) {
		this.vicitimAddress = vicitimAddress;
	}

	public String getVictimPhone() {
		return victimPhone;
	}

	public void setVictimPhone(String victimPhone) {
		this.victimPhone = victimPhone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(victimID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VictimImpl other = (VictimImpl) obj;
		return victimID == other.victimID;
	}

	@Override
	public String toString() {
		return "victimID: " + victimID + ", victimName: " + victimName + ", vicitimAddress: " + vicitimAddress
				+ ", victimPhone: " + victimPhone + "]";
	}
	
	
	
}


