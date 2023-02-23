package com.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.dao.CrimeOperation;
import com.dao.CrimeOperationImpl;
import com.dto.Crime;
import com.dto.CrimeImpl;
import com.exception.NoCrimeFoundException;
import com.exception.SomeThingWrongException;



public class CrimeUI {
	CrimeOperation cop;
	Scanner sc;
	
	CrimeUI(Scanner sc){
		cop = new CrimeOperationImpl();
		this.sc = sc;
	}
	
	public void crimeMenu(int cheese) {
		int choice;
		do {
			
			System.out.println("1. Add Crime");
			System.out.println("2. Update Crime");
			System.out.println("3. Delete Crime");
			System.out.println("4. Get Information on Crime");
			System.out.println("0. Go back to Main Menu");
			System.out.println("Please Enter Selection");			
			choice = sc.nextInt();
			switch(choice) {
			case 1:AddCrime();
				break;
			case 2:updateCrimeStatus();
				break;
			case 3:deleteCrime();
				break;
			case 4:getAllCrime();
				break;
			case 9:choice=0;
			break;
		
			}
			
		} while (choice!=0);
	}
	
	public void AddCrime() {
		System.out.println("Please enter crimeID, date, place, description, Detailed description & Status of Crime");
		Crime c = new CrimeImpl(sc.nextInt(), LocalDate.parse(sc.next()), sc.next(), sc.next(), sc.next(), sc.next());
		
		try {
			cop.addCrime(c);
			System.out.println("Crime Added Successfully");
		} catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCrimeStatus() {
		System.out.println("Please enter crime_Status followed by crimeID");
		String status = sc.next();
		int crimeId = sc.nextInt();
		
		try {
			cop.updateCrimeStatus(status, crimeId);
			System.out.println("Crime Status Updated Successfully");
		} catch (SomeThingWrongException e) {			
			e.printStackTrace();
		}
		
	}
	
	public void deleteCrime() {
		System.out.println("Please enter crimeID that you wish to delete");
		int crimeId = sc.nextInt();
		
		try {
			cop.deleteCrime(crimeId);
			System.out.println("Crime Deleted Successfully");
		} catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
	}	
	
	public void getAllCrime(){
		int choice;
		do {
			System.out.println("1. Get All Crime Information");
			System.out.println("2. Get Crime by status OR place OR date");
			System.out.println("0. Go back to previous menu");
			choice=sc.nextInt();
			switch(choice) {
			case 1: getAllCrimes();
				break;
			case 2: getCrimebySingleParameter();
				break;
			
			}
			
		} while (choice!=0);
	}
	
	public void getAllCrimes() {
		Crime c = new CrimeImpl(0, null, null, null, null, null);
		
		try {
			List<Crime> list =  cop.getAllCrime(c);
			list.forEach(System.out::println);
		} catch (NoCrimeFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void getCrimebySingleParameter() {
		int choice;
		do {
			System.out.println("1. Get Crimes by Status");
			System.out.println("2. Get Crimes by Date");
			System.out.println("3. Get Crimes by place");
			System.out.println("0. Go back to Previous Menu");
			System.out.println("Please Enter Selection");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
			}
		} while (choice!=0);
	}
}


