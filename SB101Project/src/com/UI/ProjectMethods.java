package com.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.dao.ProjectRequirementImpl;
import com.dao.ProjectRequirements;
import com.dto.Crime;
import com.dto.CrimeImpl;
import com.dto.Criminal;
import com.dto.CriminalImpl;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public class ProjectMethods {
	ProjectRequirements pro;
	Scanner sc;
	
	public ProjectMethods(Scanner sc) {
		pro = new ProjectRequirementImpl();
		this.sc = sc;
	}
	
	public void getCrimeCommByCrim() {
		System.out.println("Enter CriminalId to Fetch Records");
		try {			
			List<Crime> list =  pro.getCrimesComittedByCriminal(sc.nextInt());
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			list.forEach(System.out::println);
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		} catch (NoRecordFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void getCriminalByCrime() {
		System.out.println("Enter CrimeID to Fetch Records");
		try {			
			List<Criminal> list =  pro.getCriminalAssociatedByCrimes(sc.nextInt());
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			list.forEach(System.out::println);
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		} catch (NoRecordFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCrimeStatus() {
		try {
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			System.out.println("Please Enter Status of existing Crime followed by CrimeID");
			pro.updateCrimeStatus(sc.next(), sc.nextInt());
			System.out.println("Crime Status updated Successfully");
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		} catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void SearchCrime() {
		try {
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			System.out.println("Enter Query type followed by Query\n");
			System.out.println("Example: query_Type: status , query: pending");
			List<Crime> list = pro.getCrimesByQuery(sc.next(), sc.next());
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\nAnswer:");
			list.forEach(System.out::println);
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		} catch (NoRecordFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void SearchCriminal() {
		try {
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			System.out.println("Enter Query type followed by Query\n");
			// require conditioning for age and other values
			System.out.println("Example: query_Type: gender , query: male");
			String que = sc.next();			
			List<Criminal> list = pro.getCriminalsByQuery(que, sc.next());
			list.forEach(System.out::println);
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		} catch (NoRecordFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void NoOfCrimeByStatus() {
		System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		try {
			List list = pro.getNumOfSolvedUnsolvedCrimes();
			list.forEach(System.out::println);
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		} catch (NoRecordFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void NoOfCrimeCurrentMonth(){
		try {
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\nAnswer: ");
			int ans = pro.CrimesRecordedInCurrentMonth();
			System.out.println("Crimes recorded in current month: --> "+ans);
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		} catch (NoRecordFoundException | SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void addCrime() {
		System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		System.out.println("Enter CrimeID, date, place, description, detailed_description, status");
		Crime c = new CrimeImpl(0, LocalDate.parse(sc.next()), sc.next(), sc.next(), sc.next(), sc.next());
		try {
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			pro.addCrime(c);
			System.out.println("Crime Added Successfully");
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			}
		 catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addCriminal() {
		System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		System.out.println("Enter name, age, gender, address, idmark");
		Criminal c = new CriminalImpl(0, sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next());
		try {
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			int criminalID = pro.addCriminal(c);
			System.out.println("Criminal Added Successfully, Generated CriminalID: "+criminalID);
			System.out.println("\n*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
		
			}
		 catch (SomeThingWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
