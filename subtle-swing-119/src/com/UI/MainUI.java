package com.UI;

import java.util.Scanner;

public class MainUI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CrimeUI cUI = new CrimeUI(sc);
		CriminalUI crUI = new CriminalUI(sc);
		VictimUI vUI = new VictimUI();
		CombinationUI comUI = new CombinationUI();
		
		int choice;
		
		do {
			System.out.println("Welcome Officer, How Can CrimeChase be of Service to You?");
			System.out.println("1. Crime");
			System.out.println("2. Criminal");
			System.out.println("3. Victim");
			System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
			
			System.out.println("Please Enter Selection: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: cUI.crimeMenu(0);
				break;
			case 2: 
				break;
			case 3: 
				break;
				
			}
			
		} while (choice!=0);
	}
}

