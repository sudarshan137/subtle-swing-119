package com.dao;

import java.util.List;

import com.dto.Crime;
import com.dto.Criminal;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public interface ProjectRequirements {
	public List<Crime> getCrimesComittedByCriminal(int criminalID) throws NoRecordFoundException, SomeThingWrongException;
	public List<Criminal> getCriminalAssociatedByCrimes(int crimeID) throws NoRecordFoundException, SomeThingWrongException;
	public List<Crime> getSolvedCrimes(String status) throws NoRecordFoundException, SomeThingWrongException;
	public List<Crime> getUnsolvedCrimes(String status) throws NoRecordFoundException, SomeThingWrongException;
	public void updateCrimeStatus(String status, int crimeId) throws SomeThingWrongException;
	public List<Crime> getCrimesByArea(String area) throws NoRecordFoundException, SomeThingWrongException;
	public List<Criminal> getCriminalsByArea(String area) throws NoRecordFoundException, SomeThingWrongException;
	public List<Crime> getNumOfSolvedUnsolvedCrimes() throws NoRecordFoundException, SomeThingWrongException;
	public List<Crime> CrimesRecordedInThatMonth() throws NoRecordFoundException,SomeThingWrongException;
	
}
