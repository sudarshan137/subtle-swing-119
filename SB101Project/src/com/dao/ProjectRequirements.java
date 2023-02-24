package com.dao;

import java.util.List;

import com.dto.Crime;
import com.dto.Criminal;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public interface ProjectRequirements {
	public List<Crime> getCrimesComittedByCriminal(int criminalID) throws NoRecordFoundException, SomeThingWrongException;
	public List<Criminal> getCriminalAssociatedByCrimes(int crimeID) throws NoRecordFoundException, SomeThingWrongException;
	public void updateCrimeStatus(String status, int crimeId) throws SomeThingWrongException;
	public List<Crime> getCrimesByQuery(String que,String str) throws NoRecordFoundException, SomeThingWrongException;
	public List<Criminal> getCriminalsByQuery(String que,String str) throws NoRecordFoundException, SomeThingWrongException;
	public List getNumOfSolvedUnsolvedCrimes() throws NoRecordFoundException, SomeThingWrongException;
	public int CrimesRecordedInCurrentMonth() throws NoRecordFoundException,SomeThingWrongException;
	public void addCrime(Crime crime) throws SomeThingWrongException;
	public void addCriminal(Criminal criminal) throws SomeThingWrongException;
	public List<Crime> getCrimesList() throws NoRecordFoundException, SomeThingWrongException;
	public int getLatestCrimeID() throws NoRecordFoundException, SomeThingWrongException;
	public int getLatestCriminalID() throws NoRecordFoundException, SomeThingWrongException;
}
