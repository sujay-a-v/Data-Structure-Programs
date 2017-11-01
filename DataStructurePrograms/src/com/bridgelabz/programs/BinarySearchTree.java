package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class BinarySearchTree {
	
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int size=sc.nextInt();
		Utility utility=new Utility();
		int number;
		while(size>0)
		{
			System.out.println("enter the number of node");
			number=sc.nextInt();
			System.out.println("total number of BST for "+number+" is "+utility.numTree(number));
			size--;
		}

	}
	
}
