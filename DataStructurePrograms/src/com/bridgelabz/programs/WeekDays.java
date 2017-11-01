package com.bridgelabz.programs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;


public class WeekDays {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the month");
		int m=scan.nextInt();
		System.out.println("enter the year");
		int y=scan.nextInt();
		int d=1;
		Utility utility=new Utility();
		
		utility.daysOfWeek(m,y,d);
		
	}

}
