package com.bridgelabz.programs;

import java.util.Scanner;
import java.util.Stack;

import com.bridgelabz.utility.Utility;

public class BalancedParentheses {

	public static void main(String[] args)throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the expression");
		String expression=scan.nextLine();
		
		Utility utility=new Utility();
		
		boolean status=utility.balanced_Parentheses(expression);
		
		if(status)
		{
			System.out.println("Arithmatic Expression is balanced");
		}
		else
		{
			System.out.println("Arithmatic Expression is un-balanced");
		}

	}

}
