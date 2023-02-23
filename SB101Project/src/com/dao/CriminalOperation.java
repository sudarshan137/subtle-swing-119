package com.dao;

import java.util.List;

import com.dto.Criminal;
import com.exception.NoCriminalFoundException;
import com.exception.SomeThingWrongException;

public interface CriminalOperation {
	public void addCriminal(Criminal criminal) throws SomeThingWrongException;
	public void updateCriminal(Criminal criminal)throws SomeThingWrongException;
	public void deleteCriminal(int id) throws SomeThingWrongException;
	public List<Criminal> getAllCriminals() throws NoCriminalFoundException, SomeThingWrongException;
//	public List<Criminal> getCriminalsByCrime(int crimeId)throws NoCriminalFoundException, SomeThingWrongException;
	
}
