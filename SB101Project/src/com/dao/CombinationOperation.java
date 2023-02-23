package com.dao;

import java.util.List;

import com.dto.Criminal;
import com.dto.Victim;
import com.exception.NoCriminalFoundException;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public interface CombinationOperation {
	public void addCrimeSuspect(int crimeId, int criminalId) throws SomeThingWrongException;
	public void removeCrimeSuspect(int crimeId, int criminalId)throws SomeThingWrongException;
	public List<Criminal> getSuspectsByCrime(int crimeId) throws NoCriminalFoundException, NoRecordFoundException;
	public void addCrimeVictim(int crimeId, int victimId)throws SomeThingWrongException;
	public void removeCrimeVictim(int crimeId, int victimId) throws SomeThingWrongException;
	public List<Victim> getVictimsByCrime(int crimeId);
}
