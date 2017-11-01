package com.bridgelabz.programs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class DequePalindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String string=sc.nextLine();
		
		Utility utility=new Utility();
		boolean status =utility.deque_Palindrome(string);
		
		if(status)
		{
			System.out.println(status);
		}
		else
		{
			System.out.println(status);
		}
		
	}

}
