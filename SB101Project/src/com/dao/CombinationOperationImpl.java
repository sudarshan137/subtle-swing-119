package com.dao;

import java.util.List;

import com.dto.Criminal;
import com.dto.Victim;
import com.exception.NoCriminalFoundException;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public class CombinationOperationImpl implements CombinationOperation{

	@Override
	public void addCrimeSuspect(int crimeId, int criminalId) throws SomeThingWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCrimeSuspect(int crimeId, int criminalId) throws SomeThingWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Criminal> getSuspectsByCrime(int crimeId) throws NoCriminalFoundException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCrimeVictim(int crimeId, int victimId) throws SomeThingWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCrimeVictim(int crimeId, int victimId) throws SomeThingWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Victim> getVictimsByCrime(int crimeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
