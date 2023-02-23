package com.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.dao.CriminalOperation;
import com.dao.CriminalOperationImpl;
import com.dao.CriminalOperation;
import com.dao.CriminalOperationImpl;
import com.dto.Criminal;
import com.dto.CriminalImpl;
import com.exception.NoCriminalFoundException;
import com.exception.SomeThingWrongException;



public class CriminalUI {
	CriminalOperation crop;
	Scanner sc;
	
	CriminalUI(Scanner sc){
		crop = new CriminalOperationImpl();
		this.sc = sc;
	}
	
	public void criminalMenu(int cheese) {
		int choice;
		do {
			
			System.out.println("1. Add Criminal");
			System.out.println("2. Update Criminal");
			System.out.println("3. Delete Criminal");
			System.out.println("4. Get Information on Criminal");
			System.out.println("0. Go back to Main Menu");
			System.out.println("Please Enter Selection");			
			choice = sc.nextInt();
			switch(choice) {
			case 1:AddCriminal();
				break;
			case 2:
				break;
			case 3:deleteCriminal();
				break;
			case 4:getAllCriminal();
				break;
			case 9:choice=0;
			break;
		
			}
			
		} while (choice!=0);
	}
	
	public void AddCriminal() {
		System.out.println("Please enter CriminalID, name, age, gender, address, identifying_mark,area_of_crime");
		Criminal c = new CriminalImpl(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
		
		try {
			crop.addCriminal(c);
			System.out.println("Criminal Added Successfully");
		} catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteCriminal() {
		System.out.println("Please enter CriminalID that you wish to delete");
		int CriminalId = sc.nextInt();
		
		try {
			crop.deleteCriminal(CriminalId);
			System.out.println("Criminal Deleted Successfully");
		} catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
	}	
	
	public void getAllCriminal(){
		int choice;
		do {
			System.out.println("1. Get All Criminal Information");
			System.out.println("2. Get Criminal by status OR place OR date");
			System.out.println("0. Go back to previous menu");
			choice=sc.nextInt();
			switch(choice) {
			case 1: getAllCriminals();
				break;
			case 2: getCriminalbySingleParameter();
				break;
			
			}
			
		} while (choice!=0);
	}
	
	public void getAllCriminals() {
//		Criminal c = new CriminalImpl(0, null, 0, null, null, null,null);
		
		try {
			List<Criminal> list =  crop.getAllCriminals();
			list.forEach(System.out::println);
		} catch (NoCriminalFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void getCriminalbySingleParameter() {
		int choice;
		do {
			System.out.println("1. Get Criminals by Status");
			System.out.println("2. Get Criminals by Date");
			System.out.println("3. Get Criminals by place");
			System.out.println("0. Go back to Previous Menu");
			System.out.println("Please Enter Selection");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
			}
		} while (choice!=0);
	}
}


