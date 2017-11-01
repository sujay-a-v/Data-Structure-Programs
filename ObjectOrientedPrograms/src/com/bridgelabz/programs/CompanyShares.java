package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;


public class CompanyShares {
	
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		Utility utility=new Utility();
		int number;
		
		CompanyShares cs=new CompanyShares();
		int pos=0;
		while(true)
		{
			System.out.println("1 for add");
			System.out.println("2 for remove");
			System.out.println("3 for display");
			System.out.println("0 for exit");
			
			System.out.println("enter your choice");
			number=sc.nextInt();
			
			switch(number)
			{
			case 1: pos=utility.add();
			break;
			case 2: pos=utility.remove(pos);
			break;
			case 3: utility.disp();
			break;
			case 0: System.exit(0);;
			default : System.out.println("enter the currect input");
			}
			
		}

	}

}
