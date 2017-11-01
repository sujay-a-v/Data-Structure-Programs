package com.bridgelabz.programs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.utility.Utility;

public class RegularExpression {
     
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the first name");
		String fname=scan.nextLine();
		System.out.println("enter the full name");
		String lname=scan.nextLine();
		System.out.println("enter the contact number");
		String number=scan.nextLine();
		
		Utility utility=new Utility();
		utility.regular_Expression(fname,lname,number);
		}

}
