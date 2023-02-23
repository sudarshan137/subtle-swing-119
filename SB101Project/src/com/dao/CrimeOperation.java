package com.dao;

import java.util.List;

import com.dto.Crime;
import com.exception.NoCrimeFoundException;
import com.exception.SomeThingWrongException;

public interface CrimeOperation {
	public void addCrime(Crime crime) throws SomeThingWrongException;
	public void updateCrimeStatus(String status, int crimeID)throws SomeThingWrongException;
	public void deleteCrime(int id)throws SomeThingWrongException;
	public List<Crime> getAllCrime(Crime crime)throws NoCrimeFoundException, SomeThingWrongException;
//	public List<Crime> getCrimesByStatus(String status)throws NoCrimeFoundException, SomeThingWrongException;
//	public List<Crime> getCrimesByDate(Date date)throws NoCrimeFoundException, SomeThingWrongException;
//	public List<Crime> getCrimesByPlace(String place)throws NoCrimeFoundException, SomeThingWrongException;
}
