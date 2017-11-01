package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Calendar {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		int date=1;
		
		Utility utility=new Utility();
		utility.calendar(month,year,date);
		
	}

}
