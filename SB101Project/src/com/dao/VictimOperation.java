package com.dao;

import java.util.List;

import com.dto.Victim;
import com.exception.NoVictimFoundException;
import com.exception.SomeThingWrongException;

public interface VictimOperation {
	public void addVictim(Victim victim)throws SomeThingWrongException;
	public void updateVictim(Victim victim)throws SomeThingWrongException;
	public void deleteVictim(int id)throws SomeThingWrongException;
	public List<Victim> getAllVictims() throws NoVictimFoundException, SomeThingWrongException;
}
