package com.bridgelabz.programs;

import java.util.*;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

	public class CashCounter {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Welcome to State Bank");
		
		System.out.println("enter the number of people");
		int people=scan.nextInt();
		Utility utility=new Utility();
		utility.cash_Counter(people);
		
	}

}
