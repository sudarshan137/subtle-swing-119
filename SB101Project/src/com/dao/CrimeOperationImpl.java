package com.dao;

import java.util.List;

import com.dto.Crime;
import com.exception.NoCrimeFoundException;
import com.exception.SomeThingWrongException;

public class CrimeOperationImpl implements CrimeOperation {

	@Override
	public void addCrime(Crime crime) throws SomeThingWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCrimeStatus(String status, int crimeID) throws SomeThingWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCrime(int id) throws SomeThingWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Crime> getAllCrime(Crime crime) throws NoCrimeFoundException, SomeThingWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
