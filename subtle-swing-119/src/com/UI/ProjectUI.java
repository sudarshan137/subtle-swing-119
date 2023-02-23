package com.UI;

import java.util.List;

import com.dao.ProjectRequirementImpl;
import com.dao.ProjectRequirements;
import com.dto.Crime;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public class ProjectUI {
	public static void main(String[] args) {
		ProjectRequirements pr = new ProjectRequirementImpl();
		
		try {
			List<Crime> list =  pr.getCrimesComittedByCriminal(1);
			list.forEach(System.out::println);
		} catch (NoRecordFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
}
