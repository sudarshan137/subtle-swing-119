package com.UI;

import java.util.List;
import java.util.Scanner;

import com.dao.ProjectRequirementImpl;
import com.dao.ProjectRequirements;
import com.dto.Crime;
import com.dto.Criminal;
import com.exception.NoRecordFoundException;
import com.exception.SomeThingWrongException;

public class ProjectUI {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
				
		ProjectMethods pm = new ProjectMethods(sc);
		
		
		
		int choice;
		
		do {
			System.out.println("Welcome Office, How can CrimeChase be of service to you today?");
			System.out.println("1. Get Crimes Comitted by Criminal");
			System.out.println("2. Get Criminals Associated with Crime");
			System.out.println("3. Update Crime Status");
			System.out.println("4. Search Crimes by Query");
			System.out.println("5. Search Criminals by Query");
			System.out.println("6. Get status of crimes by number");
			System.out.println("7. Get Total Number of Crimes Recorded in current Month");
			System.out.println("8. Add Crime");
			System.out.println("9. Add Criminal");
			System.out.println("0. To Exit\n");
			System.out.println("*=*==*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			System.out.println("Please Enter Selection");
			choice = sc.nextInt();
			switch(choice) {
			case 1: pm.getCrimeCommByCrim();
				break;
			case 2: pm.getCriminalByCrime();
			break;
			case 3: pm.updateCrimeStatus();
			break;
			case 4: pm.SearchCrime();
			break;
			case 5: pm.SearchCriminal();
			break;
			case 6: pm.NoOfCrimeByStatus();
			break;
			case 7: pm.NoOfCrimeCurrentMonth();
			break;
			case 8: pm.addCrime();
			break;
			case 9: pm.addCriminal();
			break;			
			}
			if(choice!=0)Thread.sleep(2500);
		} while (choice!=0);
	}
}
